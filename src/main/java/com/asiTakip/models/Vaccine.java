package com.asiTakip.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Document(collection = "Vaccine")
public class Vaccine {
	@Id
	private Integer id;
	private Integer ownerId;
	private String name;
	private String description;
	private String hospital;
	private Date    toDoDate;
	private boolean isDone;
	
	@Transient
	public static final String SEQUENCE_NAME = "vac_sequence";
	
	
	public Vaccine(Integer id, Integer ownerId, String name, String description, String hospital, Date toDoDate,
			boolean isDone) {
		
		this.id = id;
		this.ownerId = ownerId;
		this.name = name;
		this.description = description;
		this.hospital = hospital;
		this.toDoDate = toDoDate;
		this.isDone = isDone;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	public Date getToDoDate() {
		return toDoDate;
	}
	public void setToDoDate(Date toDoDate) {
		this.toDoDate = toDoDate;
	}
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	
	
	

	
}
