package com.app.doctor.s_apointment.repo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.doctor.s_apointment.beans.Slot;

@Repository
public interface SlotRepository extends MongoRepository<Slot, Integer>{
	

	@Query("{slot_date: ?0, slot_start_time: ?1}")
	Slot getByDateTime(LocalDate slot_date, LocalTime slot_start_time);
	
	@Query("{'slot_doctor_id': ?0}")
	List<Slot> unCateredSlotById(String doctorId);

	@Query("{'slot_doctor_id': ?0, 'slot_date':?1}")
	List<Slot> cateredSlotById(String doctorId, LocalDate date);

//	@Query("slot_id:?0, slot_patient_id:?1")
//	int bookSlot(String slotId, String patientId);
	
	 @Query("{ 'slotid' : ?0 }")
	    void bookSlot(@Param("slotId") int slotId, @Param("patientId") String patientId);

	@Query("{ 'slotid' : ?0 }")
	int changeStatus(String slotId);

	@Query("{ 'slot_doctor_id' : ?0 }")
	List<Slot> getBookedSlot(String doctor_id);
	
	Slot findFirstByOrderBySlotidDesc();

}
