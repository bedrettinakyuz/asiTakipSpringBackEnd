package com.asiTakip.models;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection ="db_sequence")
@Data

public class UserSequence {

	@Id
	private String id;
	private int seqNo;
	
	
	public UserSequence(String id, int seqNo) {
		super();
		this.id = id;
		this.seqNo = seqNo;
	}
	public UserSequence() {

	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}
	
	
	


	
}
