package com.asiTakip.models;



import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection = "users")
public class User {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
	private String username;
	private String password;

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
