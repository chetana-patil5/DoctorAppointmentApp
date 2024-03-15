package com.app.doctor.s_apointment.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.doctor.s_apointment.beans.Prescription;
import com.app.doctor.s_apointment.service.PrescriptionService;

@RestController
@RequestMapping("/prescription")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PrescriptionController {

	private final Path fileStorageLocation = Paths.get("webapp/images/");//relative path

	@Autowired
	PrescriptionService prescriptionService;

	@GetMapping("/{patientId}")
	public List<Prescription> getById(@PathVariable String patientId) {
		System.out.println("*****"+patientId + "*****");
		return prescriptionService.getByStringId(patientId);
	}
	
	@GetMapping("/get/{patientId}&{prescriptionDate}")
	public List<Prescription> getByIdDate(@PathVariable String patientId, @PathVariable Date prescriptionDate) {
		System.out.println("*****"+patientId + "*****");
		return prescriptionService.getByStringIdDate(patientId, prescriptionDate);
	}
	
	@PostMapping("/addPrescription")
	public Prescription add_Prescription(@RequestBody Prescription pr){
		System.out.println("******" + pr + "******");
		return  prescriptionService.addPrescription(pr);
	}
	
	@DeleteMapping("/delete/{prescriptionId}")
	public void deleteById(@PathVariable int prescriptionId)
	{
		prescriptionService.deleteById(prescriptionId);
	}
	
	@PostMapping("/uploadFile/{patientId}")
	public String storeFile(@RequestParam("file")MultipartFile file ,@PathVariable("patientId") String patientId) {
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
			return prescriptionService.updateImage(fileStorageLocation+"\\"+fileName,patientId);

		} catch (IOException ex) {
			System.out.println("Could not store file " + fileName + ". Please try again!");
		}

		return prescriptionService.updateImage(fileName,patientId);
	}
}
