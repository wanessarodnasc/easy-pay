package com.nubank.easypay.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nubank.easypay.model.Address;
import com.nubank.easypay.model.Company;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase
public class CompanyRepositoryTest {
	
	@Autowired
	private CompanyRepository repository;

	@Test
	public void saveUser() throws Exception {
		Company company = repository.save(new Company());
		assertNotNull(company.getId());
	}
	
	@Test
    public void findAll() {
		Company company = new Company("Test", "Test", getAddress(), "teste:1234");
        repository.save(company);
        assertNotNull(repository.findAll());
    }

	private Address getAddress() {
		return new Address(12, "streetAddress", "city", "state","zipCode", "Brasil");
	}
}
