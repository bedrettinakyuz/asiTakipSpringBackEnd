
package com.asiTakip.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asiTakip.Business.IUserManager;
import com.asiTakip.Request.UserRequest;

import org.springframework.web.bind.annotation.RequestMethod;



@RestController
@RequestMapping("/signup")
public class SignUpController {


	
	private IUserManager userManager;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public SignUpController(IUserManager userManager) {

		this.userManager = userManager;
	}




	@RequestMapping(method=RequestMethod.POST)
	public String SignUp(@RequestBody UserRequest userRequest) {
        userRequest.setPassword(bCryptPasswordEncoder.encode(userRequest.getPassword()));
		return userManager.saveUser(userRequest);	
		
	}
	
}
