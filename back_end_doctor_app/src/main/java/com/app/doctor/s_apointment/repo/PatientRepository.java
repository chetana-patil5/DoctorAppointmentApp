package com.app.doctor.s_apointment.repo;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.doctor.s_apointment.beans.Doctor;
import com.app.doctor.s_apointment.beans.Patient;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String>{

	Doctor findFirstByOrderByUserIdDesc();
}
