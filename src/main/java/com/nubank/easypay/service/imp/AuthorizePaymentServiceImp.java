package com.nubank.easypay.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nubank.easypay.enumeration.AuthorizePaymentEnum;
import com.nubank.easypay.form.Custumer;
import com.nubank.easypay.model.Company;
import com.nubank.easypay.repository.CompanyRepository;
import com.nubank.easypay.service.AuthorizePaymentService;
import com.nubank.easypay.service.LogRequestService;
import com.nubank.easypay.service.client.CustumerInformationClient;
import com.nubank.easypay.service.client.ProcessPaymentClient;

@Service
public class AuthorizePaymentServiceImp implements AuthorizePaymentService{
	
	@Autowired
	private CustumerInformationClient custumerInfomation;
	
	@Autowired
	private ProcessPaymentClient processPayment;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private LogRequestService logRequestService;
	
	@Override
	public String autorizePayment(String cpf, String companyCode) {
		
		Optional<Company> company = companyRepository.findByCode(companyCode);
		if(!company.isPresent() || company.get().getStatus()) {
			return AuthorizePaymentEnum.INACTIVE_COMPANY.getDescription();
		}
		String paymentStatus = processPayment(cpf);
		logRequestService.saveLogInformation(cpf, companyCode, paymentStatus);
		return paymentStatus;
	}

	private String processPayment(String cpf) {
		String paymentStatus;
		try {
			Custumer custumer = custumerInfomation.searchCustumerByCpf(cpf);
			if( custumer.getIsAvaliableToCpfPayment() == false) {
				return AuthorizePaymentEnum.PAYMENT_CPF_DISABLED.getDescription();
			}
			paymentStatus = processPayment.processPayment(cpf);
		} catch (Exception e) {
			return AuthorizePaymentEnum.PROCESSING_ERROR.getDescription();
		}
		return paymentStatus;
	}
}
