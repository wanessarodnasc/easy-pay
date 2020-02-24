package com.nubank.easypay.service;

import javax.validation.Valid;

public interface RegisterUserService {

	boolean registerNewUser(@Valid String cpf);

}
