package com.nubank.easypay.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nubank.easypay.form.CompanyInsertForm;
import com.nubank.easypay.form.CompanyUpdateForm;
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
		String accessData = service.registerNewCompany(new CompanyInsertForm("00.000.000/0001-00", "Test 1", getAddress()));
		assertNotNull(accessData);
	}
	
	@Test
	public void registerUpdateCompany() throws Exception {
		Company company = repository.save(new Company("00.000.000/0001-01", "Test 2", getAddress(), "teste:1234"));
		company.getAddress().setStreetAddress("New Address");
		String msg = service.registerUpdateCompany(new CompanyUpdateForm(company));
		assertEquals(msg, "Company updated.");
		Optional<Company> companySaved = repository.findById(company.getId());
		assertEquals(companySaved.get().getAddress().getStreetAddress(), "New Address");
	}
	
	@Test
	public void updateCredentials() throws Exception {
		Company company = repository.save(new Company("00.000.000/0001-02", "Test 2", getAddress(), "teste:1234"));
		String accessData = service.updateCredentials(company.getCode());
		assertNotNull(accessData);
	}
	
	@Test
	public void deleteCompany() throws Exception {
		Company company = repository.save(new Company("00.000.000/0001-03", "Test 3", getAddress(), "teste:1234"));
		String msg = service.deleteCompany(company.getCode());
		assertEquals(msg, "Company deleted sucessufully.");
	}

	private Address getAddress() {
		return new Address(12, "streetAddress", "city", "state", "zipCode", "Brasil");
	}
}
