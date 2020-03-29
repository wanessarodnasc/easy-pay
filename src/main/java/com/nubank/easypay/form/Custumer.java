package com.nubank.easypay.form;


public class Custumer {
	
	private String cpf;
	
	private String completeName;
	
	private CardDataForm cardData;
	
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

	public CardDataForm getCardData() {
		return cardData;
	}

	public void setCardData(CardDataForm cardData) {
		this.cardData = cardData;
	}

	public Boolean getIsAvaliableToCpfPayment() {
		return isAvaliableToCpfPayment;
	}

	public void setIsAvaliableToCpfPayment(Boolean isAvaliableToCpfPayment) {
		this.isAvaliableToCpfPayment = isAvaliableToCpfPayment;
	}
	
}
