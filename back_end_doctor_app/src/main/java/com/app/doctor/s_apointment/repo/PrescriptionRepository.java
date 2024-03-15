package com.app.doctor.s_apointment.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.doctor.s_apointment.beans.Prescription;

@Repository
public interface PrescriptionRepository extends MongoRepository<Prescription, Integer>{

	@Query("{ 'patient_id ' : ?0 }")
	List<Prescription> getByStringId(String patientId);

	@Query("{ update prescription set 'prescription_image':?0, 'patient_id':?1 }")
	int updateImage(String fileName, String patientId);

	@Query("{ 'patient_id' : ?0, 'prescription_date' : ?1 }")
	List<Prescription> getByStringIdDate(String patientId, Date prescriptionDate);

	@Query("{ 'prescription_id' : ?0 }")
	Prescription getById(int prescriptionId);

}
