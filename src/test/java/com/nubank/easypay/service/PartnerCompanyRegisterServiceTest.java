package com.nubank.easypay.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.nubank.easypay.model.Address;
import com.nubank.easypay.model.Company;
import com.nubank.easypay.repository.CompanyRepository;

@RunWith(SpringRunner.class)
public class PartnerCompanyRegisterServiceTest {

	@Autowired
	private PartnerCompanyRegisterService service;
	
	@Autowired
	private CompanyRepository repository;

	@Test
	public void registerNewCompany() throws Exception {
		String accessData = service.registerNewCompany(new Company("Test", "Test", getAddress(), "teste:1234"));
		assertNotNull(accessData);
	}
	
	@Test
	public void registerUpdateCompany() throws Exception {
		Company company = repository.save(new Company("Test", "Test", getAddress(), "teste:1234"));
		String msg = service.registerUpdateCompany(company.getId());
		assertEquals(msg, "OK");
	}
	
	@Test
	public void updateCredentials() throws Exception {
		Company company = repository.save(new Company("Test", "Test", getAddress(), "teste:1234"));
		String accessData = service.updateCredentials(company.getId());
		assertNotNull(accessData);
	}
	
	@Test
	public void deleteCompany() throws Exception {
		Company company = repository.save(new Company("Test", "Test", getAddress(), "teste:1234"));
		String msg = service.deleteCompany(company.getId());
		assertEquals(msg, "OK");
	}

	private Address getAddress() {
		return new Address(12, "streetAddress", "city", "state", "zipCode");
	}
}
