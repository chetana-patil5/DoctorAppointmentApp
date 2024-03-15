package com.app.doctor.s_apointment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.doctor.s_apointment.beans.Patient;
import com.app.doctor.s_apointment.service.PatientService;

@RestController
@RequestMapping("/patient")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@PostMapping("/add")
	public ResponseEntity<?>  addPatient(@RequestBody Patient patient){
		Patient save = this.patientService.addPatient(patient);
		return ResponseEntity.ok(save);
	}
	
	@GetMapping("/allPatients")
	public ResponseEntity<?> getPatints(){
		return ResponseEntity.ok(this.patientService.getAllPatients());
	}
	
	 @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable String id) {
        return patientService.getById(id);
    }
	
	 @DeleteMapping("/deletePatient/{patient_id}")
    public void deletePatient(@PathVariable String id) {
		patientService.deleteById(id);
    }
	 
	 @PutMapping("/updatePatient/{patientId}")
	    public Patient updatePatient(@PathVariable String patientId, @RequestBody Patient p)
	    {
	    	return patientService.updatePatient(patientId, p);
	    }
}
