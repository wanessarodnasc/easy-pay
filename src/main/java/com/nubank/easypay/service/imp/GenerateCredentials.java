package com.nubank.easypay.service.imp;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import com.nubank.easypay.model.AccessData;

@Service
public class GenerateCredentials {
	
	public AccessData generateAccessCredentials(String cnpj) {
		return new AccessData(cnpj, generateRandomPassword(cnpj));
	}
	
	private String generateRandomPassword(String cnpj) {
		String password = RandomStringUtils.randomAscii(10, 25);
		//Enviar email 
		return password;//new BCryptPasswordEncoder().encode(password);
	}
}
