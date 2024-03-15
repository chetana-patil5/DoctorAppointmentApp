package com.app.doctor.s_apointment.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.doctor.s_apointment.beans.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category,Integer> {

}
