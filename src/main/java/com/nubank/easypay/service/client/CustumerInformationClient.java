package com.nubank.easypay.service.client;

import com.nubank.easypay.form.Custumer;

public interface CustumerInformationClient {
	
	Custumer searchCustumerByCpf(String cpf);

}
