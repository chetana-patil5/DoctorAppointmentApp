package com.app.doctor.s_apointment.service;

import java.util.List;

import com.app.doctor.s_apointment.beans.Doctor;

public interface DoctorService {
	 Doctor addDoctor(Doctor dr);

	    List<Doctor> getBySpecialization(String category);

	    //String storeFile(MultipartFile file);

	    Doctor deleteById(String doctor_id);

		Doctor updateDoctor(String doctorId, Doctor doc);

		List<Doctor> getDrByLocation(String location);

		List<Doctor> getDrByVerificationStatus(Boolean verificationStatus);

	    Doctor getDoctorById(String user_id);
	    
	    List<Doctor> getAllDoctors();

		String updateImage(String string, String user_id);
}
