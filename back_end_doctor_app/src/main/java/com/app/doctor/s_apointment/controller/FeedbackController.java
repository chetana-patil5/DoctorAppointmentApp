package com.app.doctor.s_apointment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.doctor.s_apointment.beans.Feedback;
import com.app.doctor.s_apointment.service.FeedbackService;

@RestController
@RequestMapping("/feedback")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FeedbackController {

	@Autowired
	FeedbackService feedbackService;
	
	@PostMapping("/addFeedback")
    public Feedback addFeedback(@RequestBody Feedback fd){
        System.out.println("******" + fd + "******");
        return  feedbackService.addFeedback(fd);
    }
	
	@GetMapping("/rating/{doctorid}")
    public int getAverageRating(@PathVariable String doctorid){
        System.out.println("******" + doctorid + "******");
        return  feedbackService.getAverageRating(doctorid);
    }
	
	@GetMapping("/{doctorid}")
    public List<Feedback> getFeedback(@PathVariable String doctorid){
        System.out.println("******" + doctorid + "******");
        return  feedbackService.getFeedback(doctorid);
    }
	
	@DeleteMapping("/delete/{feedbackid}")
    public void deleteFeedback(@PathVariable int feedbackid){
        System.out.println("******" + feedbackid + "******");
          feedbackService.deleteFeedback(feedbackid);
    }
}
