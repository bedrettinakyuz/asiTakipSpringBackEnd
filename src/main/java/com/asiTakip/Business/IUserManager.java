package com.asiTakip.Business;



import com.asiTakip.Request.UserRequest;

public interface IUserManager {

	String saveUser(UserRequest userRequest);
	
	Integer getUserID(String username);
}
