package com.app.doctor.s_apointment.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.doctor.s_apointment.beans.User;

@Repository
public interface UserRepository extends MongoRepository<User, Integer>{

	@Query("{ 'user_id' : ?0 }")
	User getById(String userId);

	@Query("{ 'user_email' : ?0 }")
	User getByEmail(String emailId);

	@Query("{ 'user_email' : ?0, 'user_password' : ?1 }")
	User getByEmail(String emailId, String password);

}
