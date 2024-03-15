package com.app.doctor.s_apointment.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.doctor.s_apointment.beans.Clinic;
import com.app.doctor.s_apointment.service.ClinicService;

@RestController
@RequestMapping("/clinic")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClinicController {
	private final Path fileStorageLocation = Paths.get("webapp/images/clinic");//relative path
	
	@Autowired
	ClinicService clinicService;

		@PostMapping("/add")
		public Clinic addClinic(@RequestBody Clinic c){
			return clinicService.addClinic(c);
		}
		
		@GetMapping("/get/{doctorId}")
		public List<Clinic> getClinics(@PathVariable String doctorId){
			return  clinicService.getClinics(doctorId);
		}
		
		@PostMapping("/uploadFile/{clinic_id}/{doctor_id}")
		private String storeFile(@RequestParam("file") MultipartFile file ,@PathVariable int clinic_id,@PathVariable String doctor_id) {
			// Normalize file name
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

				return clinicService.updateImage(fileStorageLocation+"\\"+fileName, clinic_id,doctor_id);

			} catch (IOException ex) {
				System.out.println("Could not store file " + fileName + ". Please try again!");
			}

			return clinicService.updateImage(fileName,clinic_id,doctor_id);
		}
}
