package com.asiTakip.resources;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.asiTakip.Business.IUserManager;
import com.asiTakip.Request.LoginRequest;
import com.asiTakip.Responses.LoginResponse;
import com.asiTakip.auth.TokenManager;


@RestController
@RequestMapping("/login")

public class AuthController {


	@Autowired
	private TokenManager tokenManager;
	@Autowired
	private AuthenticationManager authenticationManager;
	

	
	

	@PostMapping
	public  ResponseEntity<LoginResponse> Login(@RequestBody LoginRequest loginRequest){
	
		try {
		
			if (!authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())).isAuthenticated() )
			{
				
				return new ResponseEntity<LoginResponse>(new LoginResponse(401,"UNAUTHORIZED"),HttpStatus.UNAUTHORIZED) 	;	
			}

			return new ResponseEntity<LoginResponse>(new LoginResponse(200,"OK",tokenManager.generateToken(loginRequest.getUsername())),HttpStatus.OK) 	;	
			
			
					
		}

		catch(Exception e){
			e.printStackTrace();	
            throw new AuthenticationCredentialsNotFoundException("Fields must not be empty", e);
            
		}
		
		
		
	}
	
	@GetMapping
	public String Logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
        if (auth != null){     
            new SecurityContextLogoutHandler().logout(request, response, auth);  
           
            
         }  
          return "Logout";  
	}
}
