package com.nubank.easypay.form;

import javax.validation.constraints.Email;

import com.nubank.easypay.model.Address;
import com.sun.istack.NotNull;

public class CompanyInsertForm {

	@NotNull
	private String code;

	@NotNull
	private String name;
	
	@Email
	@NotNull
	private String email;

	private AddressForm address;

	public CompanyInsertForm(String code, String name, String email, Address address) {
		this.code = code;
		this.name = name;
		this.email = email;
		this.address = new AddressForm(address);
	}
	
	public CompanyInsertForm() {
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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AddressForm getAddress() {
		return address;
	}

	public void setAddress(AddressForm address) {
		this.address = address;
	}
}
