package com.app.doctor.s_apointment.beans;



import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Slot")
public class Slot {
	
//	slot_id
//	slot_patient_id
//	slot_doctor_id
//	slot_date
//	slot_start_time
//	slot_status
	
	@Id
	private int slotid;
	   
    private String slot_patient_id;
  
    private String slot_doctor_id;

    private LocalDate slot_date;
   
    private LocalTime slot_start_time;
   
    private LocalTime slot_end_time;

    private  boolean slot_status;

	public Slot() {
		super();
	}

	public Slot(int slotid, String slot_patient_id, String slot_doctor_id, LocalDate slot_date,
			LocalTime slot_start_time, LocalTime slot_end_time, boolean slot_status) {
		super();
		this.slotid = slotid;
		this.slot_patient_id = slot_patient_id;
		this.slot_doctor_id = slot_doctor_id;
		this.slot_date = slot_date;
		this.slot_start_time = slot_start_time;
		this.slot_end_time = slot_end_time;
		this.slot_status = slot_status;
	}

	public int getSlotid() {
		return slotid;
	}

	public void setSlotid(int slotid) {
		this.slotid = slotid;
	}

	public String getSlot_patient_id() {
		return slot_patient_id;
	}

	public void setSlot_patient_id(String slot_patient_id) {
		this.slot_patient_id = slot_patient_id;
	}

	public String getSlot_doctor_id() {
		return slot_doctor_id;
	}

	public void setSlot_doctor_id(String slot_doctor_id) {
		this.slot_doctor_id = slot_doctor_id;
	}

	public LocalDate getSlot_date() {
		return slot_date;
	}

	public void setSlot_date(LocalDate slot_date) {
		this.slot_date = slot_date;
	}

	public LocalTime getSlot_start_time() {
		return slot_start_time;
	}

	public void setSlot_start_time(LocalTime slot_start_time) {
		this.slot_start_time = slot_start_time;
	}

	public LocalTime getSlot_end_time() {
		return slot_end_time;
	}

	public void setSlot_end_time(LocalTime slot_end_time) {
		this.slot_end_time = slot_end_time;
	}

	public boolean isSlot_status() {
		return slot_status;
	}

	public void setSlot_status(boolean slot_status) {
		this.slot_status = slot_status;
	}

}
