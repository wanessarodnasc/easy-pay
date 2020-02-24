package com.nubank.easypay.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nubank.easypay.service.RegisterUserService;

@RestController
public class RegisterUserController {
	

	@Autowired
	private RegisterUserService service;
		
	@PostMapping("register-new-user")
	public ResponseEntity<Boolean> registerNewUser(@RequestBody @Valid String cpf) {
		Boolean registered = service.registerNewUser(cpf);
		return ResponseEntity.ok(registered);
	}
}
