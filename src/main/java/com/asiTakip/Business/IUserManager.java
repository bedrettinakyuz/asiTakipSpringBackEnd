package com.asiTakip.Business;


import com.asiTakip.models.User;

public interface IUserManager {
String saveUser(User user);
Integer getUserID(String username);
	
}
