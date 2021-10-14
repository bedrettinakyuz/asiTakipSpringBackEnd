package com.asiTakip.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.asiTakip.models.*;
@Repository
public interface VaccineRepository extends MongoRepository<Vaccine,Integer>{
 
public List<Vaccine> findByOwnerId(Integer ownerId);
	
}
