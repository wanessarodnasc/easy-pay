package com.nubank.easypay.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.nubank.easypay.form.AddressForm;

@Entity
@Table(name = "address")
public class Address implements Serializable {
	
	private static final long serialVersionUID = -8183945029317727347L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "streetAddress", nullable = false)
	private String streetAddress;

	@Column(name = "houseNumber", nullable = false)
	private int houseNumber;

	@Column(name = "city", nullable = false)
	private String city;

	@Column(name = "state", nullable = false)
	private String state;

	@Column(name = "zipCode", nullable = false)
	private String zipCode;
	
	@Column(name = "country", nullable = false)
	private String country;
	
	public Address() {
	}

	public Address(int houseNumber, String streetAddress, String city, String state, String zipCode, String country) {
		this.houseNumber = houseNumber;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
	}

	public Address(AddressForm address) {
		this.houseNumber = address.getHouseNumber();
		this.streetAddress = address.getStreetAddress();
		this.city = address.getCity();
		this.state = address.getState();
		this.zipCode = address.getZipCode();
		this.country = address.getCountry();
	}
	
	public int getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
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
