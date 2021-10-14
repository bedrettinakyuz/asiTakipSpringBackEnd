package com.asiTakip.DAL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asiTakip.repository.UserRepository;
@Repository
public class UserDAL implements IUserDAL {

	@Autowired
	private UserRepository userRepository;
	@Override
	public Integer getUserID(String userName) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(userName).getId();
	}

	
}
