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

import com.nubank.easypay.form.Custumer;
import com.nubank.easypay.service.client.CustumerInformationClient;

@Service
public class CustumerInformationClientImp implements CustumerInformationClient {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustumerInformationClientImp.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${service.custumer.information}")
	private String url;
	
	@Value("${service.variable.cpf}")
	private String cpfVariable;
	
	@Override
	public Custumer searchCustumerByCpf(String cpf) {
		UriComponents uri = UriComponentsBuilder.fromUriString(url)
				.queryParam(cpfVariable, cpf).build();
		
		LOGGER.info(MessageFormat.format("Calling web service custumer information: {0}", uri));
		
		return restTemplate.getForObject(uri.toUriString(), Custumer.class);
	}

}
