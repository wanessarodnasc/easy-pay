package com.nubank.easypay.service.imp;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.nubank.easypay.service.RegisterUserService;

@Service
public class RegisterUserServiceImp implements RegisterUserService{

	@Override
	public boolean registerNewUser(@Valid String cpf) {
		boolean registered = true;
		return registered;
	}

}
