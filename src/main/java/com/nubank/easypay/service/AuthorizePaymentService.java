package com.nubank.easypay.service;

import javax.validation.Valid;

public interface AuthorizePaymentService {

	boolean autorizePayment(@Valid String cpf);

}
