package com.app.doctor.s_apointment.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.doctor.s_apointment.beans.Clinic;

@Repository
public interface ClinicRepository extends MongoRepository<Clinic, Integer>{

	@Query("{ 'update clinic set clinic_image' : ?0, 'clinic_id' : ?1, 'clinic_doctor_id' : ?2")
	int updateImage(String fileName, int clinic_id, String doctor_id);

    @Query("{ 'clinic_doctor_id' : ?0 }")
	List<Clinic> findAllByDoctorId(String doctorId);
    
    @Query("{ 'clinic_id' : ?0 }")
	Clinic getById(int clinicId);

    @Query("{ 'clinic_doctor_id' : ?0 }")
	List<Clinic> deleteByDoctorId(String doctorId);

}
