package com.nubank.easypay.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class AccessData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "address_seq_gen")
	@SequenceGenerator(name = "address_seq_gen", sequenceName = "ADDRESS_SEQ")
	private Long id;
	
	private String login;
	
	private String password;
	
	private String status;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
