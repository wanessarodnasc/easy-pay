package com.nubank.easypay.form;

import com.nubank.easypay.model.Address;
import com.nubank.easypay.model.Company;
import com.sun.istack.NotNull;

public class CompanyUpdateForm {
	
	@NotNull
	private String code;

	private AddressForm address;

	public CompanyUpdateForm(String code, Address address) {
		this.code = code;
		this.address = new AddressForm(address);
	}

	public CompanyUpdateForm(Company company) {
		this.code = company.getCode();
		this.address = new AddressForm(company.getAddress());
	}

	public CompanyUpdateForm() {
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public AddressForm getAddress() {
		return address;
	}

	public void setAddress(AddressForm address) {
		this.address = address;
	}
}
