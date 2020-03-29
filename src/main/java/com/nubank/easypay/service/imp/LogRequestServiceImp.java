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
	public LogRequest saveLogInformationStart(LogRequest log) {
		return repository.save(new LogRequest(log.getCustumerCpf(), log.getCompanyCode(), LocalDateTime.now()));
	}

	@Override
	public LogRequest updateLogFinishProcess(LogRequest log, String status) {
		log.setStatus(status);
		log.setDataTimeEnd(LocalDateTime.now());
		LogRequest logUpdated = repository.save(log);
		return logUpdated;
	}
}
