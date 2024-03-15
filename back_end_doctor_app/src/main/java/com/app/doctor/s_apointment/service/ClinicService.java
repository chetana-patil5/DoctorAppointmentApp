package com.app.doctor.s_apointment.service;

import java.util.List;

import com.app.doctor.s_apointment.beans.Clinic;

public interface ClinicService {
	Clinic addClinic(Clinic c);

    String updateImage(String fileName,int clinic,String doctor_id);

    List<Clinic> getClinics(String doctorId);

	void deleteClinicById(int clinicId);

	void deleteClinic(String doctorId);
}
