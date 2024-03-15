package com.app.doctor.s_apointment.service;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.doctor.s_apointment.beans.Prescription;

public interface PrescriptionService {

	List<Prescription> getByStringId(String patientId);

	Prescription addPrescription(Prescription pr);

	String updateImage(String string, String patientId);

	String storeFile(MultipartFile file);

	void deleteById(int prescriptionId);

	List<Prescription> getByStringIdDate(String patientId, Date prescriptionDate);

}
