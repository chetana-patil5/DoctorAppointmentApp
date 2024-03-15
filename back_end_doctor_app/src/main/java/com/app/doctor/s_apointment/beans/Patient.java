package com.app.doctor.s_apointment.beans;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Patient")
public class Patient extends User{
	
//	patient_emergency_contact
//	patient_health_problem
	 private String patient_emergency_contact;
	    
	    private String patient_health_problem;

	    public Patient(){
	        super();
	    }

		public Patient(String patient_emergency_contact, String patient_health_problem) {
			super();
			this.patient_emergency_contact = patient_emergency_contact;
			this.patient_health_problem = patient_health_problem;
		}

		public String getPatient_emergency_contact() {
			return patient_emergency_contact;
		}

		public void setPatient_emergency_contact(String patient_emergency_contact) {
			this.patient_emergency_contact = patient_emergency_contact;
		}

		public String getPatient_health_problem() {
			return patient_health_problem;
		}

		public void setPatient_health_problem(String patient_health_problem) {
			this.patient_health_problem = patient_health_problem;
		}
}
