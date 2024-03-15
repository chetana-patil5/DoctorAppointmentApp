package com.app.doctor.s_apointment.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.app.doctor.s_apointment.beans.Prescription;
import com.app.doctor.s_apointment.repo.PrescriptionRepository;

@Service
public class PrescriptionServiceImpl implements PrescriptionService{

	private final Path fileStorageLocation = Paths.get("webapp/images/prescription");
	
	@Autowired
	PrescriptionRepository prescriptionRepository;
	
	@Override
	public List<Prescription> getByStringId(String patientId) {
		return prescriptionRepository.getByStringId(patientId);
	}
	
	@Override
	public Prescription addPrescription(Prescription pr) {
		return prescriptionRepository.save(pr);
	}

	@Override
    @Transactional
    public String updateImage(String fileName, String patientId) {
        System.out.println(fileName+"in service----------------------------------------------------"+patientId);
        int x= prescriptionRepository.updateImage(fileName,patientId);
        if(x > 0)
            return fileName;
        return "not updated";
    }

	@Override
    public String storeFile(MultipartFile file) {
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

            return fileName;
        } catch (IOException ex) {
            System.out.println("Could not store file " + fileName + ". Please try again!");
        }
        return fileStorageLocation+fileName;
    }


	@Override
	public void deleteById(int prescriptionId) {
		Prescription pr = prescriptionRepository.getById(prescriptionId);
		
		prescriptionRepository.delete(pr);
	}

	@Override
	public List<Prescription> getByStringIdDate(String patientId, Date prescriptionDate) {
		return prescriptionRepository.getByStringIdDate(patientId, prescriptionDate);
	}

}
