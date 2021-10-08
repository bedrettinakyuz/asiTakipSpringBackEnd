package com.asiTakip.resources;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.asiTakip.Business.IUserManager;

@RestController
@RequestMapping("/user")
public class UserController {

	private IUserManager userManager;
	@Transactional
	@GetMapping("/getUserId/{username}")
	public Integer SignUp(@PathVariable String username) {
        
		return userManager.getUserID(username);	
		
	}
}
