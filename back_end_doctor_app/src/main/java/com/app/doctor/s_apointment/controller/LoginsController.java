package com.app.doctor.s_apointment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.doctor.s_apointment.beans.Logins;
import com.app.doctor.s_apointment.service.LoginsService;

@RestController
@RequestMapping("/logins")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginsController {

	@Autowired
	private LoginsService loginsService;
	
	@DeleteMapping("/{user_id}")
	public void deleteLogin(@PathVariable String user_id) {
		loginsService.deleteLogins(user_id);
	}
	
	@GetMapping("/")
    public ResponseEntity<?> getAllLogins(){
    	return ResponseEntity.ok(loginsService.getAllLogins());
    }
	
	@PostMapping("/getPassword")
	public Logins getPasswordByEmail(@RequestBody Logins u){
		System.out.println("*****"+u.getUser_email()+"*****");
		System.out.println("*****"+u.getUser_password()+"*****");

		return  loginsService.getPasswordByEmail(u.getUser_email(),u.getUser_password());
	}
}
