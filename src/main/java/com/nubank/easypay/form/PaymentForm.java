package com.nubank.easypay.form;

import java.math.BigDecimal;

import com.sun.istack.NotNull;

public class PaymentForm {

	@NotNull
	private String cpf;

	@NotNull
	private String completeName;

	@NotNull
	private String companyCode;

	@NotNull
	private BigDecimal value;

	private int installment;

	public PaymentForm(String cpf, String completeName, String companyCode, BigDecimal value, int installment) {
		this.cpf = cpf;
		this.companyCode = completeName;
		this.companyCode = companyCode;
		this.value = value;
		this.installment = installment;
	}

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

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
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
