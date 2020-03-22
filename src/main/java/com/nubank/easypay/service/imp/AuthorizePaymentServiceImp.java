package com.nubank.easypay.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nubank.easypay.form.Custumer;
import com.nubank.easypay.service.AuthorizePaymentService;
import com.nubank.easypay.service.client.CustumerInformationClient;
import com.nubank.easypay.service.client.ProcessPaymentClient;

@Service
public class AuthorizePaymentServiceImp implements AuthorizePaymentService{
	
	@Autowired
	private CustumerInformationClient custumerInfomation;
	
	@Autowired
	private ProcessPaymentClient processPayment;
	
	@Override
	public String autorizePayment(String cpf) {
		String paymentStatus = processPayment(cpf);

		return paymentStatus;
	}

	private String processPayment(String cpf) {
		String paymentStatus;
		try {
			Custumer custumer = custumerInfomation.searchCustumerByCpf(cpf);
			if( custumer.getIsAvaliableToCpfPayment() == false) {
				return "User dont allow cpf payment";
			}
			paymentStatus = processPayment.processPayment(cpf);
		} catch (Exception e) {
			return "Error to processing payment.";
		}
		return paymentStatus;
	}
}
