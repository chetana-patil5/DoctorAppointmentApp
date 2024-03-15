package com.app.doctor.s_apointment.beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Feedback")
public class Feedback {

	@Id
	private int feedback_id;

    private int feedback_rating;

    private String feedback_text;

    private String feedback_doctor_id;

    private String feedback_patient_id;

	public Feedback() {
		super();
	}

	public Feedback(int feedback_id, int feedback_rating, String feedback_text, String feedback_doctor_id,
			String feedback_patient_id) {
		super();
		this.feedback_id = feedback_id;
		this.feedback_rating = feedback_rating;
		this.feedback_text = feedback_text;
		this.feedback_doctor_id = feedback_doctor_id;
		this.feedback_patient_id = feedback_patient_id;
	}

	public int getFeedback_id() {
		return feedback_id;
	}

	public void setFeedback_id(int feedback_id) {
		this.feedback_id = feedback_id;
	}

	public int getFeedback_rating() {
		return feedback_rating;
	}

	public void setFeedback_rating(int feedback_rating) {
		this.feedback_rating = feedback_rating;
	}

	public String getFeedback_text() {
		return feedback_text;
	}

	public void setFeedback_text(String feedback_text) {
		this.feedback_text = feedback_text;
	}

	public String getFeedback_doctor_id() {
		return feedback_doctor_id;
	}

	public void setFeedback_doctor_id(String feedback_doctor_id) {
		this.feedback_doctor_id = feedback_doctor_id;
	}

	public String getFeedback_patient_id() {
		return feedback_patient_id;
	}

	public void setFeedback_patient_id(String feedback_patient_id) {
		this.feedback_patient_id = feedback_patient_id;
	}
}
