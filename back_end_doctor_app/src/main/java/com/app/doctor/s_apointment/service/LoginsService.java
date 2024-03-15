package com.app.doctor.s_apointment.service;

import java.util.List;

import com.app.doctor.s_apointment.beans.Logins;


public interface LoginsService {
       
	Logins addLogins(Logins p);
	Boolean deleteLogins(String id);
	List<Logins> getAllLogins();
	Logins getPasswordByEmail(String emailId,String password);
}
