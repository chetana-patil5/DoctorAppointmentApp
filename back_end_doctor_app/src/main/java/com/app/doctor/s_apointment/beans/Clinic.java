package com.app.doctor.s_apointment.beans;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Clinic")
public class Clinic {

	 private int clinic_id;
	    
	    private String clinic_doctor_id;

	    private String clinic_image;

		public Clinic() {
			super();
		}

		public Clinic(int clinic_id, String clinic_doctor_id, String clinic_image) {
			super();
			this.clinic_id = clinic_id;
			this.clinic_doctor_id = clinic_doctor_id;
			this.clinic_image = clinic_image;
		}

		public int getClinic_id() {
			return clinic_id;
		}

		public void setClinic_id(int clinic_id) {
			this.clinic_id = clinic_id;
		}

		public String getClinic_doctor_id() {
			return clinic_doctor_id;
		}

		public void setClinic_doctor_id(String clinic_doctor_id) {
			this.clinic_doctor_id = clinic_doctor_id;
		}

		public String getClinic_image() {
			return clinic_image;
		}

		public void setClinic_image(String clinic_image) {
			this.clinic_image = clinic_image;
		}
	    
}
