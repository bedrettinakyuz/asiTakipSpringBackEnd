package com.asiTakip.auth;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.asiTakip.repository.UserRepository;
@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;	
	@Autowired
	private UserRepository userRepository;
 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

	   try {
			
			
			String hashPas = userRepository.findByUsername(username).getPassword();
			
			return new User(username,hashPas,true,true,true,true,AuthorityUtils.NO_AUTHORITIES);
		}
		catch(UsernameNotFoundException exception)
		{
			throw new UsernameNotFoundException(username);}
		
		
		
	}

}
