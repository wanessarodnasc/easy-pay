package com.nubank.easypay.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nubank.easypay.enumeration.AuthorizePaymentEnum;
import com.nubank.easypay.form.Custumer;
import com.nubank.easypay.form.PaymentForm;
import com.nubank.easypay.form.PaymentRequestForm;
import com.nubank.easypay.model.Company;
import com.nubank.easypay.model.LogRequest;
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
	public String autorizePayment(PaymentForm payment) {
		LogRequest log = logRequestService.saveLogInformationStart(new LogRequest(payment.getCpf(), payment.getCompanyCode()));
		String status = validatePayment(payment); 
		logRequestService.updateLogFinishProcess(log, status);
		return status;
	}
	
	private String validatePayment(PaymentForm payment) {
		Optional<Company> company = companyRepository.findByCode(payment.getCompanyCode());
		if(!company.isPresent() || company.get().getStatus() == false) {
			return AuthorizePaymentEnum.INACTIVE_COMPANY.getDescription();
		}
		Custumer custumer = custumerInfomation.searchCustumerByCpf(payment.getCpf());
		if( custumer == null) {
			return AuthorizePaymentEnum.CUSTUMER_DOES_NOT_EXIST.getDescription();
		}
		if( custumer.getIsAvaliableToCpfPayment() == false) {
			return AuthorizePaymentEnum.PAYMENT_CPF_DISABLED.getDescription();
		}
		return processPayment(custumer, payment); 
	}

	private String processPayment(Custumer custumer, PaymentForm payment) {
		PaymentRequestForm form = createPaymentRequestForm(custumer, payment);
		try {
			return processPayment.processPayment(form);
		} catch (Exception e) {
			return AuthorizePaymentEnum.PROCESSING_ERROR.getDescription();
		}
	}

	private PaymentRequestForm createPaymentRequestForm(Custumer custumer, PaymentForm payment) {
		return new PaymentRequestForm(custumer.getCompleteName(), 
				custumer.getCpf(),
				custumer.getCardData(), 
				payment.getInstallment(), 
				payment.getValue());
	}
}
