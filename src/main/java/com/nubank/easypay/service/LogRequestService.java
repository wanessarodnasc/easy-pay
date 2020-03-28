package com.nubank.easypay.service;

public interface LogRequestService {
	
	void saveLogInformation(String cpf, String companyCode, String paymentStatus);

}
