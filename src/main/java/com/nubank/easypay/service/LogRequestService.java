package com.nubank.easypay.service;

import com.nubank.easypay.model.LogRequest;

public interface LogRequestService {
	
	LogRequest saveLogInformationStart(LogRequest log);

	LogRequest updateLogFinishProcess(LogRequest log, String status);

}
