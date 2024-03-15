package com.app.doctor.s_apointment.beans;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Prescription")
public class Prescription {

	@Id
    private int prescription_id;
    
    private String patient_id;
    
    private String doctor_id;

    private Date prescription_date;

    private String prescription_image;

	public Prescription() {
		super();
	}

	public Prescription(int prescription_id, String patient_id, String doctor_id, Date prescription_date,
			String prescription_image) {
		super();
		this.prescription_id = prescription_id;
		this.patient_id = patient_id;
		this.doctor_id = doctor_id;
		this.prescription_date = prescription_date;
		this.prescription_image = prescription_image;
	}

	public int getPrescription_id() {
		return prescription_id;
	}

	public void setPrescription_id(int prescription_id) {
		this.prescription_id = prescription_id;
	}

	public String getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}

	public String getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(String doctor_id) {
		this.doctor_id = doctor_id;
	}

	public Date getPrescription_date() {
		return prescription_date;
	}

	public void setPrescription_date(Date prescription_date) {
		this.prescription_date = prescription_date;
	}

	public String getPrescription_image() {
		return prescription_image;
	}

	public void setPrescription_image(String prescription_image) {
		this.prescription_image = prescription_image;
	}
}
