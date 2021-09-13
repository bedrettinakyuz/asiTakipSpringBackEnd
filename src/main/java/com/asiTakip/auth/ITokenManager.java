package com.asiTakip.auth;

public interface ITokenManager {

	public String generateToken(String username);
	public boolean tokenValidate(String token);
	public String getUsernameToken(String token);
	public boolean isExpired(String token);
}
