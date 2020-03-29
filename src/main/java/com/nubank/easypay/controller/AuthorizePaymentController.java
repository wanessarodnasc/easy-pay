package com.nubank.easypay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nubank.easypay.form.PaymentForm;
import com.nubank.easypay.service.AuthorizePaymentService;

@RestController
public class AuthorizePaymentController {
	
	@Autowired
	private AuthorizePaymentService service;
	
	@PostMapping("authorize-payment")
    public ResponseEntity<String> authorizePayment(@RequestBody PaymentForm payment)  {
		String autorized = service.autorizePayment(payment);
    	return ResponseEntity.ok().body(autorized);
    }
}
