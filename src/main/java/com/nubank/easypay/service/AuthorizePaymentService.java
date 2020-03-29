package com.nubank.easypay.service;

import com.nubank.easypay.form.PaymentForm;

public interface AuthorizePaymentService {

	String autorizePayment(PaymentForm payment);

}
