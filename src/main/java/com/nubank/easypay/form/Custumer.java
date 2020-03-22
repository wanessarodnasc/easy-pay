package com.nubank.easypay.form;

public class Custumer {
	
	private String cpf;
	
	private String completeName;
	
	private String cardNumber;
	
	private String expiredDate;
	
	private String code; 
	
	private Boolean isAvaliableToCpfPayment;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCompleteName() {
		return completeName;
	}

	public void setCompleteName(String completeName) {
		this.completeName = completeName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(String expiredDate) {
		this.expiredDate = expiredDate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Boolean getIsAvaliableToCpfPayment() {
		return isAvaliableToCpfPayment;
	}

	public void setIsAvaliableToCpfPayment(Boolean isAvaliableToCpfPayment) {
		this.isAvaliableToCpfPayment = isAvaliableToCpfPayment;
	}
}
