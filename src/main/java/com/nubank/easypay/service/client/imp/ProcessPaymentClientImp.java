package com.nubank.easypay.service.client.imp;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.nubank.easypay.form.PaymentRequestForm;
import com.nubank.easypay.service.client.ProcessPaymentClient;

@Service
public class ProcessPaymentClientImp implements ProcessPaymentClient{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustumerInformationClientImp.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${service.process.payment}")
	private String url;
	
	@Value("${service.variable.cpf}")
	private String cpfVariable;

	@Override
	public String processPayment(PaymentRequestForm payment) {
		UriComponents uri = UriComponentsBuilder.fromUriString(url).queryParam(cpfVariable, payment).build();
		LOGGER.info(MessageFormat.format("Calling web service process payment: {0}", uri));
		return restTemplate.postForEntity(uri.toUriString(), payment, String.class).getBody();
	}
}
