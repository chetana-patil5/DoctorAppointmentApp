package com.app.doctor.s_apointment.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.doctor.s_apointment.beans.Doctor;

@Repository
public interface DoctorRepository extends MongoRepository<Doctor, String>{

	@Query("{'doctor_category': ?0}")
	List<Doctor> getBySpecialization(String category);

	@Query("{ 'doctor_clinic_address ' : ?0 }")
	List<Doctor> getDrByLocation(String location);

	@Query("{ 'doctor_verification_status' : ?0 }")
	List<Doctor> getDrByVerificationStatus(Boolean verificationStatus);

	@Query("{ 'userId' : ?1 }")
	int updateImage(String fileName, String user_id);

	Doctor findFirstByOrderByUserIdDesc();
}
