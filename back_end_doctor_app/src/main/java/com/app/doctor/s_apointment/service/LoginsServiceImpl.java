package com.app.doctor.s_apointment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.doctor.s_apointment.beans.Logins;
import com.app.doctor.s_apointment.repo.LoginsRepository;

@Service
public class LoginsServiceImpl implements LoginsService{
	
	@Autowired
	LoginsRepository loginsRepository;

	@Override
	public Logins addLogins(Logins p) {
		return loginsRepository.save(p);
	}

	@Override
	public Boolean deleteLogins(String patient_id) {
		loginsRepository.deleteById(patient_id);
		return null;	 
	}
	
	@Override
	public List<Logins> getAllLogins() {
		return loginsRepository.findAll();
	}

	@Override
	public Logins getPasswordByEmail(String emailId, String password) {
		Logins user = loginsRepository.getByEmail(emailId, password);
		if(user != null) {
			return user;
		}
		return null;
	}

}
