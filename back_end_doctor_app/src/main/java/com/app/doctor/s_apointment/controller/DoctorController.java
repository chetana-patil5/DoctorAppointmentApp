package com.app.doctor.s_apointment.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.doctor.s_apointment.beans.Doctor;
import com.app.doctor.s_apointment.service.DoctorService;

@RestController
@RequestMapping("/doctor")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DoctorController {
	
	private final Path fileStorageLocation = Paths.get("webapp/images/");

	@Autowired
	DoctorService doctorService;
	
	@PostMapping("/add")
	public ResponseEntity<?>  addDoctor(@RequestBody Doctor doctor){
		Doctor save = this.doctorService.addDoctor(doctor);
		return ResponseEntity.ok(save);
	}
	
	@GetMapping
	public ResponseEntity<?> getAllDoctors(){
		return ResponseEntity.ok(this.doctorService.getAllDoctors());
	}
	
	 @GetMapping("/{id}")
	    public Doctor getDoctorById(@PathVariable String id) {
	        return doctorService.getDoctorById(id);
	    }
	 
	 @DeleteMapping("/deleteDoctor/{doctor_id}")
	    public Doctor deleteDoctor(@PathVariable String id) {
		 return doctorService.deleteById(id);
	    }
	 
	 @GetMapping("cat/{category}")
		public ResponseEntity<?> getBySpecialization(@PathVariable String category) {
			System.out.println("******" + category + "******");
			return ResponseEntity.ok(this.doctorService.getBySpecialization(category));
		}
	 
	 @GetMapping("/get/{location}")
		public ResponseEntity<?> getDrByLocation(@PathVariable String location)
		{
			System.out.println("******" + location + "******");
			return ResponseEntity.ok(this.doctorService.getDrByLocation(location));
		}
	 
	 @GetMapping("/getDoctor/{verificationStatus}")
		public ResponseEntity<?> getDrByVerificationStatus(@PathVariable Boolean verificationStatus)
		{
			System.out.println("******" + verificationStatus + "******");
			return ResponseEntity.ok(this.doctorService.getDrByVerificationStatus(verificationStatus));
		}
	 
	 @PutMapping("/updateDoctor/{doctorId}")
		public Doctor updateDoctor(@PathVariable String doctorId, @RequestBody Doctor doc)
		{
			return doctorService.updateDoctor(doctorId, doc);
		}

	 @PostMapping("/uploadFile/{user_id}")
		public String storeFile(@RequestParam("file")MultipartFile file ,@PathVariable("user_id") String user_id) {
			// Normalize file name
			// stores file and return directory path
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());

			try {
				Files.createDirectories(this.fileStorageLocation);
			} catch (Exception ex) {
				System.out.println("Could not create the directory where the uploaded files will be stored.");
			}

			try {
				// Check if the file's name contains invalid characters
				if (fileName.contains("..")) {
					throw new IOException("Sorry! Filename contains invalid path sequence " + fileName);
				}

				// Copy file to the target location (Replacing existing file with the same name)
				Path targetLocation = this.fileStorageLocation.resolve(fileName);
				Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
				return doctorService.updateImage(fileStorageLocation+"\\"+fileName,user_id);

			} catch (IOException ex) {
				System.out.println("Could not store file " + fileName + ". Please try again!");
			}

			return doctorService.updateImage(fileName,user_id);
		}

}
