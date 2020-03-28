package com.nubank.easypay.service.imp;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nubank.easypay.model.LogRequest;
import com.nubank.easypay.repository.LogRequestRepository;
import com.nubank.easypay.service.LogRequestService;

@Service
public class LogRequestServiceImp implements LogRequestService {
	
	@Autowired
	private LogRequestRepository repository;

	@Override
	public void saveLogInformation(String custumerCpf, String companyCode, String status) {
		repository.save(new LogRequest(custumerCpf, companyCode, status, LocalDateTime.now()));
	}
}
