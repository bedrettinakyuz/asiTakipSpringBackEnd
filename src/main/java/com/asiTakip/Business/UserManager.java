package com.asiTakip.Business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.asiTakip.Request.UserRequest;
import com.asiTakip.models.User;
import com.asiTakip.repository.UserRepository;
@Service
public class UserManager implements IUserManager {

	@Autowired
	private UserRepository userRepository;



	@Override
	public String saveUser(User user) {
		
		if(!userRepository.existsById(user.getId())) {
			
			
			userRepository.save(user);
			return "User saved with id : " + user.getId();
		}
		return "User already existing with that  id" + user.getId();
		
	}



	@Override
	public Integer getUserID(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username).getId();
	}

}
