package com.app.doctor.s_apointment.service;

import java.util.List;

import com.app.doctor.s_apointment.beans.Feedback;

public interface FeedbackService {
	Feedback addFeedback(Feedback fd);

	int getAverageRating(String doctor_id);

	List<Feedback> getFeedback(String doctor_id);

	void deleteFeedback(int feedbackid);
}
