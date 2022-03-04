package com.example.demo.model.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_sequence")
public class UserSequence {
	
	public UserSequence() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserSequence(String id, long seq) {
		super();
		this.id = id;
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getSeq() {
		return seq;
	}
	public void setSeq(long seq) {
		this.seq = seq;
	}
	@Id
	private String id;
	private long seq;

}
