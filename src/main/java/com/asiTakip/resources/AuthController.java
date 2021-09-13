package com.asiTakip.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asiTakip.Request.LoginRequest;
import com.asiTakip.auth.TokenManager;

@RestController
@RequestMapping("/login")

public class AuthController {

	@Autowired
	private TokenManager tokenManager;
	@Autowired
	private AuthenticationManager authenticationManager;
	@PostMapping
	public ResponseEntity<String> Login(@RequestBody LoginRequest loginRequest){
		
		try {
			System.out.println(" AuthController"+ loginRequest.getUsername() + " " + loginRequest.getPassword());
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
			
			return ResponseEntity.ok(tokenManager.generateToken(loginRequest.getUsername()));
		}catch(Exception e){
            throw new AuthenticationCredentialsNotFoundException("Fields must not be empty", e);

		}
		
	}
}
