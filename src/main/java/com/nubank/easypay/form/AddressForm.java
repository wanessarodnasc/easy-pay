package com.nubank.easypay.form;

import com.nubank.easypay.model.Address;

public class AddressForm {
	
	private String streetAddress;

	private int houseNumber;

	private String city;

	private String state;

	private String zipCode;
	
	private String country;

	public AddressForm(Address address) {
		this.streetAddress = address.getStreetAddress();
		this.city = address.getCity();
		this.state = address.getState();
		this.zipCode = address.getZipCode();
		this.country = address.getCountry();
	}
	
	public AddressForm() {
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
