package com.nubank.easypay.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import com.nubank.easypay.form.CompanyInsertForm;

@Entity
@Table(name = "company")
public class Company implements Serializable {

	private static final long serialVersionUID = -3720729525176684696L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "code", nullable = false, updatable = false)
	private String code;

	@Column(name = "name", nullable = false, updatable = false)
	private String name;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "address_id")
	private Address address;

	@Email
	@Column(name = "email", nullable = true)
	private String email;

	@Column(name = "credentials", nullable = true)
	private String credentials;
	
	@Column(name = "status", nullable = false)
	private boolean status;
	

	public Company() {
	}

	public Company(String code, String name, String email, Address address, String credentials) {
		this.code = code;
		this.name = name;
		this.email = email;
		this.address = address;
		this.credentials = credentials;
		this.status = true;
	}

	public Company(CompanyInsertForm company) {
		this.code = company.getCode();
		this.name = company.getName();
		this.email = company.getEmail();
		this.address = new Address(company.getAddress());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getCredentials() {
		return credentials;
	}

	public void setCredentials(String credentials) {
		this.credentials = credentials;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
