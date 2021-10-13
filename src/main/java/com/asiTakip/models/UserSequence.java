package com.asiTakip.models;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection ="db_sequence")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSequence {

	@Id
	private String id;
	private int seqNo;
	public int getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}
	
	
}
