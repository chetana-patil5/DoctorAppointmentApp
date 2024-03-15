package com.app.doctor.s_apointment.service;

import java.time.LocalDate;
import java.util.List;

import com.app.doctor.s_apointment.beans.Slot;

public interface SlotService {
	   Slot addSlot(Slot slot);

	    List<Slot> getAll();

		void deleteSlotById(int slotid);

		List<Slot> unCateredSlotById(String doctor_id);

		List<Slot> cateredSlotByDate(String doctor_id, LocalDate date);

		String bookSlot(String slotId, String PatientId);

		String changeSlotStaus(String slotId);

		List<Slot> getBookedSlot(String doctor_id);
}
