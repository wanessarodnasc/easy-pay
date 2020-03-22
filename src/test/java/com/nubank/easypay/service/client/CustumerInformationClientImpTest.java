package com.nubank.easypay.service.client;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nubank.easypay.form.Custumer;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustumerInformationClientImpTest {
	
	@Autowired
	private CustumerInformationClient service;
	
	@Test
	public void registerNewCompany() {
		Custumer custumer = service.searchCustumerByCpf("35177355221");
		assertNotNull(custumer);
	}

}
