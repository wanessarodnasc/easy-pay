package com.nubank.easypay.form;

import java.math.BigDecimal;

public class PaymentRequestForm {
	
	private String completeName;
	
	private String cpf;
	
	private CardDataForm cardData;
	
	private BigDecimal value; 
	
	private int installment;

	public PaymentRequestForm(String completeName, String cpf, CardDataForm cardData, int installment, BigDecimal value) {
		this.completeName = completeName;
		this.cpf = cpf;
		this.cardData = cardData;
		this.installment = installment;
		this.value = value;
	}

	public String getCompleteName() {
		return completeName;
	}

	public void setCompleteName(String completeName) {
		this.completeName = completeName;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public CardDataForm getCardData() {
		return cardData;
	}

	public void setCardData(CardDataForm cardData) {
		this.cardData = cardData;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public int getInstallment() {
		return installment;
	}

	public void setInstallment(int installment) {
		this.installment = installment;
	}
}
