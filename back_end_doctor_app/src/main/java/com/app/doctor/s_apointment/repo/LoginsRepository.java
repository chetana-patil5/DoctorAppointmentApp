 package com.app.doctor.s_apointment.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.doctor.s_apointment.beans.Logins;

@Repository
public interface LoginsRepository extends MongoRepository<Logins, String>{

//	@Query("user_email:?0, user_password:?1")
	@Query("{'user_email': ?0, 'user_password': ?1}")
	Logins getByEmail(String emailId, String password);
	
	

}
