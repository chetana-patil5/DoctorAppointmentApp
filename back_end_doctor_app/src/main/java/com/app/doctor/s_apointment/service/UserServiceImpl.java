package com.app.doctor.s_apointment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.doctor.s_apointment.beans.User;
import com.app.doctor.s_apointment.repo.DoctorRepository;
import com.app.doctor.s_apointment.repo.PatientRepository;
import com.app.doctor.s_apointment.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	DoctorRepository doctorRepository;
	@Autowired
	PatientRepository patientRepository;

	@Override
	public User getUser(String userId) {
		
		return userRepository.getById(userId);
	}

	@Override
	public User updateUser(String userId, User user) {
		
		User u = userRepository.getById(userId);
		String userPassword = user.getUser_password();
		System.out.println(userPassword);
		u.setUser_password(userPassword);
		userRepository.save(u);
		
		return u;
	}

	@Override
	public User getUserByEmail(String emailId) {

		User user= userRepository.getByEmail(emailId);
		User user1 = user;
		user1.setUser_password("null");
		return user1;
	}
	
	@Override
	public User updateUserPassword(String emailId, User user) {
		User u = userRepository.getByEmail(emailId);
		String userPassword = user.getUser_password();
		System.out.println(userPassword);
		u.setUser_password(userPassword);
		userRepository.save(u);
		
		return u;
	}

	@Override
	public User getPasswordByEmail(String emailId , String password) {
		User user= userRepository.getByEmail(emailId,password);
		if(user != null) {
			return user;
//			if(user.getUser_role().equals("doctor")){
//				return doctorRepository.getById(user.getUser_id());
//			}else if(user.getUser_role().equals(("patient"))){
//				return patientRepository.getById(user.getUser_id());
//			}
		}
		return null;
	}

	@Override
	public User updateUserByEmail(String emailId, User user) {
		
		return userRepository.save(user);
	}

}
