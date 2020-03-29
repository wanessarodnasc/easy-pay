package com.nubank.easypay.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nubank.easypay.model.LogRequest;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase
public class LogRequestRepositoryTest {
	
	@Autowired
	private LogRequestRepository repository;

	@Test
	public void saveUser() throws Exception {
		LogRequest company = repository.save(new LogRequest());
		assertNotNull(company.getId());
	}
	
	@Test
	public void searchByCpf() throws Exception {
		repository.save(new LogRequest("35177355221", "00.000.000/0001-00", "APPROVED", LocalDateTime.now(), LocalDateTime.now()));
		Optional<List<LogRequest>> logsRequest = repository.findByCustumerCpf("35177355221");
		assertTrue(logsRequest.isPresent());
	}
	
	@Test
	public void searchByCompanyCode() throws Exception {
		repository.save(new LogRequest("35177355221", "00.000.000/0001-00", "APPROVED", LocalDateTime.now(), LocalDateTime.now()));
		Optional<List<LogRequest>> logsRequest = repository.findByCompanyCode("00.000.000/0001-00");
		assertNotNull(logsRequest);
	}
	
	@Test
	public void searchByStatus() throws Exception {
		repository.save(new LogRequest("35177355221", "00.000.000/0001-00", "APPROVED", LocalDateTime.now(), LocalDateTime.now()));
		Optional<List<LogRequest>> logsRequest = repository.findByStatus("APPROVED");
		assertNotNull(logsRequest);
	}
}
