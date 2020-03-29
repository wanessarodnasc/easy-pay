package com.nubank.easypay.enumeration;

public enum AuthorizePaymentEnum {
	
	INACTIVE_COMPANY("Company does not exist or is inactive."),
	PAYMENT_CPF_DISABLED("Payment with CPF is disable"),
	CUSTUMER_DOES_NOT_EXIST("CPF does not registered."),
	PROCESSING_ERROR("Processing error");
	
	private String description;

	private AuthorizePaymentEnum(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
