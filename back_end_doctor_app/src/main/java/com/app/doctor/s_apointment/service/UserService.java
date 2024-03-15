package com.app.doctor.s_apointment.service;

import com.app.doctor.s_apointment.beans.User;

public interface UserService {
	User getUser(String userId);

	User updateUser(String userId, User user);

	User getUserByEmail(String emailId);

	User updateUserPassword(String emailId, User user);

	User getPasswordByEmail(String emailId,String password);

	User updateUserByEmail(String emailId, User user);

}
