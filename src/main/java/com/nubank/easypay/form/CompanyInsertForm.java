package com.nubank.easypay.form;

import com.nubank.easypay.model.Address;

public class CompanyInsertForm {

	private String code;

	private String name;

	private AddressForm address;

	public CompanyInsertForm(String code, String name, Address address) {
		this.code = code;
		this.name = name;
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

	public AddressForm getAddress() {
		return address;
	}

	public void setAddress(AddressForm address) {
		this.address = address;
	}
}
