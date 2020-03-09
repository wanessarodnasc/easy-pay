package com.nubank.easypay.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nubank.easypay.model.Company;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase
public class CompanyRepositoryTest {
	
	@Autowired
	private CompanyRepository repository;

	@Test
	public void saveUser() throws Exception {
		repository.save(new Company());
	}
	
	@Test
    public void findAll() {
		//User user = new User("name", "name@gmail.com", "password", Arrays.asList(new Profile("USER")));
        //repository.save(user);
        //assertNotNull(repository.findAll());
    }
	

}
