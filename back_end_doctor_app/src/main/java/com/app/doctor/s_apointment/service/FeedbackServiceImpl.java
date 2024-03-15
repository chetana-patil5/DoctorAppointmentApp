package com.app.doctor.s_apointment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.doctor.s_apointment.beans.Feedback;
import com.app.doctor.s_apointment.repo.FeedbackRepository;

@Service
public class FeedbackServiceImpl implements FeedbackService{

	@Autowired
	FeedbackRepository feedbackRepository;
	
	@Override
	public Feedback addFeedback(Feedback fd) {
		 return feedbackRepository.save(fd);
	}

	@Override
	public int getAverageRating(String doctorId) {
		
		return feedbackRepository.getAverageRating(doctorId);
	}

	@Override
	public List<Feedback> getFeedback(String doctorId) {
		
		return feedbackRepository.getFeedback(doctorId);
	}

	@Override
	public void deleteFeedback(int feedbackId) {
		Feedback fd = feedbackRepository.getFeedbackById(feedbackId); 
		
		feedbackRepository.delete(fd);
	}

}
