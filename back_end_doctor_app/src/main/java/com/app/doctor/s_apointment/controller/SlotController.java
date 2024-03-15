package com.app.doctor.s_apointment.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.doctor.s_apointment.beans.Slot;
import com.app.doctor.s_apointment.service.SlotService;

@RestController
@RequestMapping("/slot")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SlotController {

	@Autowired
	SlotService slotservice;

	@PostMapping("/add")
	public Slot addSlot(@RequestBody Slot slot){
		System.out.println("*****"+slot+"*****");
		return  slotservice.addSlot(slot);
	}
	
	@GetMapping("/all")
	public List<Slot> getAllSlot(){
		return slotservice.getAll();
	}
	
	@DeleteMapping("/delete/{slot_id}")
	public void deleteSlotById(@PathVariable int slot_id){
		System.out.println("************"+slot_id+"**********************************");
		slotservice.deleteSlotById(slot_id);
	}
	
	@GetMapping("/uncatered/{doctor_id}")
	public List<Slot> unCateredSlotById(@PathVariable String doctor_id){
		return slotservice.unCateredSlotById(doctor_id);
	}
	
	@GetMapping("/catered/{doctor_id}/{date}")
	public List<Slot> cateredSlotByDate(@PathVariable String doctor_id,@PathVariable LocalDate date){
		return slotservice.cateredSlotByDate(doctor_id,date);
	}
	
	@PutMapping("/book/{slotId}/{patientId}")
	public String bookSlot(@PathVariable String slotId, @PathVariable String patientId)
	{
		System.out.println("slot id : "+slotId+" pat id "+patientId);
		return slotservice.bookSlot(slotId, patientId);
	}
	
	@PutMapping("/comp/{slotId}")
	public String bookSlot(@PathVariable String slotId)
	{
		return slotservice.changeSlotStaus(slotId);
	}
	
	@GetMapping("/incomp/{doctor_id}")
	public List<Slot> getBookedSlot(@PathVariable String doctor_id){
		return slotservice.getBookedSlot(doctor_id);
	}
}
