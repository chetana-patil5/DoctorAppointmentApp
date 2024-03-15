package com.app.doctor.s_apointment.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.doctor.s_apointment.beans.Doctor;
import com.app.doctor.s_apointment.beans.Logins;
import com.app.doctor.s_apointment.beans.Patient;
import com.app.doctor.s_apointment.repo.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService{
	
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	LoginsService logServ;

	@Override
	public Patient getById(String patientId) {
		return patientRepository.findById(patientId).orElse(null);
	}

	@Override
	public Patient addPatient(Patient d) {
		Doctor prev = patientRepository.findFirstByOrderByUserIdDesc();		
		if(prev == null)
			d.setUserId("P-100");
		else
	      d.setUserId("P-"+(Integer.parseInt(prev.getUserId().substring(2))+1));
		patientRepository.save(d);
		Logins logs = new Logins(d.getUserId(),d.getUser_email(),d.getUser_password(),"Patient");
		logServ.addLogins(logs);
		return d;
	}

	@Override
	public Boolean deleteById(String patientId) {
		try {
		patientRepository.deleteById(patientId);
		return true;
		}
		catch(NoSuchElementException e){
			return false;
		}
	}

	@Override
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	@Override
	public Patient updatePatient(String patient_id, Patient p) {
		return patientRepository.save(p);
	}

}
