package com.app.doctor.s_apointment.beans;

import javax.validation.constraints.Email;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collation = "User")
public class User {

//	user_id
//	user_full_name
//	user_address
//	user_phone_number
//	user_email
	    @Id
	    private String userId;
	    
	    
	    private String user_full_name;

	    private String user_address;
	    
	    private String user_phone_number;
	    
	    @Email
	    private String user_email;
	    
	    private String user_password;
	    
	    private String user_role;

	    public User() {
	        super();
	    }

		public User(String userId, String user_full_name, String user_address, String user_phone_number,
				String user_email, String user_password, String user_role) {
			super();
			this.userId = userId;
			this.user_full_name = user_full_name;
			this.user_address = user_address;
			this.user_phone_number = user_phone_number;
			this.user_email = user_email;
			this.user_password = user_password;
			this.user_role = user_role;
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getUser_full_name() {
			return user_full_name;
		}

		public void setUser_full_name(String user_full_name) {
			this.user_full_name = user_full_name;
		}

		public String getUser_address() {
			return user_address;
		}

		public void setUser_address(String user_address) {
			this.user_address = user_address;
		}

		public String getUser_phone_number() {
			return user_phone_number;
		}

		public void setUser_phone_number(String user_phone_number) {
			this.user_phone_number = user_phone_number;
		}

		public String getUser_email() {
			return user_email;
		}

		public void setUser_email(String user_email) {
			this.user_email = user_email;
		}

		public String getUser_password() {
			return user_password;
		}

		public void setUser_password(String user_password) {
			this.user_password = user_password;
		}

		public String getUser_role() {
			return user_role;
		}

		public void setUser_role(String user_role) {
			this.user_role = user_role;
		}
}
