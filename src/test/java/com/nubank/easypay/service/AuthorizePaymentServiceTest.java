package com.nubank.easypay.service;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nubank.easypay.form.PaymentForm;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthorizePaymentServiceTest {
	
	@Autowired
	private AuthorizePaymentService service;

	@Test
	public void autorizePayment() {
		service.autorizePayment(new PaymentForm("35177355221", "Tet payment", "00.000.000/0001-00", new BigDecimal(123.00), 1));
	}
}
