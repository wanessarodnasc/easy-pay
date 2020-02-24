package com.nubank.easypay.service.imp;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.nubank.easypay.service.AuthorizePaymentService;

@Service
public class AuthorizePaymentServiceImp implements AuthorizePaymentService{

	@Override
	public boolean autorizePayment(@Valid String cpf) {
		return false;
	}

}
