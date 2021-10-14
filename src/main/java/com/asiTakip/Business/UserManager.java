package com.asiTakip.Business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.asiTakip.DAL.IUserDAL;
import com.asiTakip.models.User;
import com.asiTakip.repository.UserRepository;
@Service
public class UserManager implements IUserManager {


	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private IUserDAL userDAL;

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


		return userDAL.getUserID(username);
	}

}
