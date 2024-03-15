package com.app.doctor.s_apointment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.doctor.s_apointment.beans.User;
import com.app.doctor.s_apointment.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {


	@Autowired
	UserService userService;

	//Get User by user Id
	@GetMapping("/get/{userId}")
	public User getUser(@PathVariable String userId){
		System.out.println("*****"+userId+"*****");
		return  userService.getUser(userId);
	}

	//Get User By email
	@GetMapping("/getByEmail/{emailId}")
	public User getUserByEmail(@PathVariable String emailId){
		System.out.println("*****"+emailId+"*****");
		return  userService.getUserByEmail(emailId);
	}

	//Get password by emailId
	@PostMapping("/getPassword")
	public User getPasswordByEmail(@RequestBody User u){
		System.out.println("*****"+u.getUser_email()+"*****");
		System.out.println("*****"+u.getUser_password()+"*****");

		return  userService.getPasswordByEmail(u.getUser_email(),u.getUser_password());
	}

	//Update password By email
	@PutMapping("/updatePassword/{emailId}")
	public User updateUserPassword(@PathVariable String emailId, @RequestBody User user){
		System.out.println("*****"+emailId+"*****");
		return  userService.updateUserPassword(emailId, user);
	}

	//Update Password By user Id
	@PutMapping("/update/{userId}")
	public User updateUserPass(@PathVariable String userId, @RequestBody User user){
		System.out.println("*****"+userId+"*****");
		return  userService.updateUser(userId, user);
	}

	//Update User By email
	@PutMapping("/updateUser/{emailId}")
	public User updateUser(@PathVariable String emailId, @RequestBody User user){
		System.out.println("*****"+emailId+"*****");
		return  userService.updateUserByEmail(emailId, user);
	}

}
