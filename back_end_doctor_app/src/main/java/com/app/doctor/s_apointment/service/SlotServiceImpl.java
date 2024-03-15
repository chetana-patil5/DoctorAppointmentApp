package com.app.doctor.s_apointment.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.doctor.s_apointment.beans.Slot;
import com.app.doctor.s_apointment.repo.SlotRepository;

@Service
public class SlotServiceImpl implements SlotService{

	@Autowired
	SlotRepository slotRepository;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	//Add Slot
		@Override
		public Slot addSlot(Slot slot) {
			Slot s = slotRepository.getByDateTime(slot.getSlot_date(),slot.getSlot_start_time());
			Slot prev = slotRepository.findFirstByOrderBySlotidDesc();
			if(prev!=null) {
				slot.setSlotid(prev.getSlotid()+1);
			}
			else {
				slot.setSlotid(1);
			}
			if(s == null){
				System.out.println("saving.....");
				return slotRepository.save(slot);
			}
			return null;
		}

		//Get All Slot
		@Override
		public List<Slot> getAll() {
			return slotRepository.findAll();
		}

	@Override
	public void deleteSlotById(int slotid) {
		slotRepository.deleteById(slotid);
	}

	@Override
	public List<Slot> unCateredSlotById(String doctorId) {

		return slotRepository.unCateredSlotById(doctorId);
	}

	@Override
	public List<Slot> cateredSlotByDate(String doctorId, LocalDate date) {
		return slotRepository.cateredSlotById(doctorId, date);
	}

	@Override
	@Transactional 
	public String bookSlot(String slotId, String patientId) {
//		slotRepository.bookSlot(slotId,patientId);
//			return "Updated";
		Query query = new Query(Criteria.where("slotid").is(Integer.parseInt(slotId)));
		Update update = new Update().set("slot_patient_id", patientId).set("slot_status", true);
		mongoTemplate.updateFirst(query, update, Slot.class);
		return "Updated";
	}

	@Override
	@Transactional
	public String changeSlotStaus(String slotId) {
		int x = slotRepository.changeStatus(slotId);
		if(x > 0)
		{
			return "Updated";
		}
		return null;    

	}
	@Override
	public List<Slot> getBookedSlot(String doctor_id) {
		List<Slot> slotList =slotRepository.getBookedSlot(doctor_id);
				if(slotList == null)
					return null;

		return slotList;
	}

}
