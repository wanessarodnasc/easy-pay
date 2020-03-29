package com.nubank.easypay.service;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nubank.easypay.model.LogRequest;
import com.nubank.easypay.repository.LogRequestRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LogRequestServiceTest {
	
	@Autowired
	private LogRequestService service;
	
	@Autowired
	private LogRequestRepository repository;
	
	@Test
	public void saveLogInformation() throws Exception {
		service.saveLogInformationStart(new LogRequest("35177355221", "00.000.000/0001-00", LocalDateTime.now()));
		Optional<List<LogRequest>> log = repository.findByCustumerCpf("35177355221");
		assertTrue(log.isPresent());
	}
}
