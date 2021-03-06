package com.asiTakip.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.asiTakip.models.User;
import com.asiTakip.Request.UserRequest;
@Repository
public interface UserRepository extends MongoRepository<User,Integer> {

 public User findByUsername(String username);
}
