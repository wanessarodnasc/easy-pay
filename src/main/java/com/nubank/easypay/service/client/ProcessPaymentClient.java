package com.nubank.easypay.service.client;

import com.nubank.easypay.form.PaymentRequestForm;

public interface ProcessPaymentClient {
	
	String processPayment(PaymentRequestForm payment);

}
