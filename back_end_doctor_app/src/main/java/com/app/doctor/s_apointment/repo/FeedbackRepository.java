package com.app.doctor.s_apointment.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.doctor.s_apointment.beans.Feedback;

@Repository
public interface FeedbackRepository extends MongoRepository<Feedback, Integer>{

	@Query("{ 'feedback_doctor_id' : ?0 }")
	int getAverageRating(String doctorId);

	@Query("{ 'feedback_doctor_id' : ?0 }")
	List<Feedback> getFeedback(String doctorId);

	@Query("{ 'feedback_id ' : ?0 }")
	Feedback getFeedbackById(int feedbackId);

}
