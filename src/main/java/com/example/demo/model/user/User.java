package com.example.demo.model.user;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document(collection = "User_db")
public class User {
	
	@Transient
	public static final String SEQUENCE_NAME = "user_Sequence";

	@Id
	private long  id;
	private String userName;
	private int age;
	private String contactNo;
	private String email;
	private Map<Long , Ticket> ticket;
	private String bank_name;
	private long account_name;
	private String creditCard;
	private String cvv;
	private LocalDate expiry_date;
	private String roles;
	
	

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public long getAccount_name() {
		return account_name;
	}

	public void setAccount_name(long account_name) {
		this.account_name = account_name;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public LocalDate getExpiry_date() {
		return expiry_date;
	}

	public void setExpiry_date(LocalDate expiry_date) {
		this.expiry_date = expiry_date;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Map<Long, Ticket> getTicket() {
		return ticket;
	}

	public void setTicket(Map<Long, Ticket> ticket) {
		this.ticket = ticket;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	

	public User(long id, String userName, int age, String contactNo, String email, Map<Long, Ticket> ticket,
			String bank_name, long account_name, String creditCard, String cvv, LocalDate expiry_date, String roles) {
		super();
		this.id = id;
		this.userName = userName;
		this.age = age;
		this.contactNo = contactNo;
		this.email = email;
		this.ticket = ticket;
		this.bank_name = bank_name;
		this.account_name = account_name;
		this.creditCard = creditCard;
		this.cvv = cvv;
		this.expiry_date = expiry_date;
		this.roles = roles;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

}
