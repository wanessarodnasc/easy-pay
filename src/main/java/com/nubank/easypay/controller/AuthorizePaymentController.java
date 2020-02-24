package com.nubank.easypay.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nubank.easypay.service.AuthorizePaymentService;

@RestController
public class AuthorizePaymentController {
	
	@Autowired
	private AuthorizePaymentService service;
	
	@GetMapping("authorize-payment")
    public ResponseEntity<Boolean> authorizePayment(@Valid @RequestParam String cpf)  {
		boolean autorized = service.autorizePayment(cpf);
    	return ResponseEntity.ok().body(autorized);
    }
}
