package com.app.doctor.s_apointment.beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "logins")
public class Logins {
	 
	    @Id	    
	    private String user_id;

	    private String user_email;
	  
	    private String user_password;
	  
	    private String user_role;

		public Logins() {
			super();
		}

		public Logins( String user_id, String user_email, String user_password, String user_role) {
			super();
			this.user_id = user_id;
			this.user_email = user_email;
			this.user_password = user_password;
			this.user_role = user_role;
		}

		public String getUser_id() {
			return user_id;
		}

		public void setUser_id(String user_id) {
			this.user_id = user_id;
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
