package com.app.doctor.s_apointment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.doctor.s_apointment.beans.Category;
import com.app.doctor.s_apointment.repo.CategoryRepository;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryController {
	
		@Autowired
		CategoryRepository categoryRepository;

		//Get All Categories
		@GetMapping("/")
		public List<Category> getAllCategory(){
			return categoryRepository.findAll();
		}
		
		@GetMapping("/{_id}")
		public ResponseEntity<?> getByCategory(@PathVariable int _id){
			return ResponseEntity.of(categoryRepository.findById(_id));
		}
}
