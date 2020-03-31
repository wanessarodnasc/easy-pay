package com.nubank.easypay.exception;

public class BussinessException extends Exception {
	
	private static final long serialVersionUID = 1L;

	private String descriptionError;

	public BussinessException(String descriptionError) {
		this.descriptionError = descriptionError;
	}

	public String getDescriptionError() {
		return descriptionError;
	}

	public void setDescriptionError(String descriptionError) {
		this.descriptionError = descriptionError;
	}
}
