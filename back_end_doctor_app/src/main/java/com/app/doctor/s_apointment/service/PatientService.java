package com.app.doctor.s_apointment.service;

import java.util.List;

import com.app.doctor.s_apointment.beans.Patient;

public interface PatientService {
	Patient getById(String patient_id);

    Patient addPatient(Patient p);

	Boolean deleteById(String patient_id);

	List<Patient> getAllPatients();

	Patient updatePatient(String patient_id, Patient p);

}
