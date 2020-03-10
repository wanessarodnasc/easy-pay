package com.nubank.easypay.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nubank.easypay.model.Address;
import com.nubank.easypay.model.Company;
import com.nubank.easypay.repository.CompanyRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
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
		company.setName("Test 2");
		String msg = service.registerUpdateCompany(company);
		assertEquals(msg, "OK");
		Optional<Company> companySaved = repository.findById(company.getId());
		assertEquals(companySaved.get().getName(), "Test 2");
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
