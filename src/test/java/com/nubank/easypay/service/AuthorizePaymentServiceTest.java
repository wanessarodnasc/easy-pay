package com.nubank.easypay.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthorizePaymentServiceTest {
	
	@Autowired
	private AuthorizePaymentService service;

	@Test
	public void autorizePayment() {
		service.autorizePayment(null);
	}
	
}
