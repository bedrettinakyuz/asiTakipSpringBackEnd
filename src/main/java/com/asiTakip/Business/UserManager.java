package com.asiTakip.Business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.asiTakip.Request.UserRequest;
import com.asiTakip.repository.UserRepository;
@Service
public class UserManager implements IUserManager {

	@Autowired
	private UserRepository userRepository;



	@Override
	public String saveUser(UserRequest userRequest) {
		
		if(!userRepository.existsById(userRequest.getId())) {
			
			//userRequest.setPassword(bCryptPasswordEncoder.encode(userRequest.getPassword()));
			userRepository.save(userRequest);
			return "User saved with id : " + userRequest.getId();
		}
		return "User already existing with that  id" + userRequest.getId();
		
	}



	@Override
	public Integer getUserID(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username).getId();
	}

}
