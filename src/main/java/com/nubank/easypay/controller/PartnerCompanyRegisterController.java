package com.nubank.easypay.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nubank.easypay.model.Company;
import com.nubank.easypay.service.PartnerCompanyRegisterService;

@RestController
public class PartnerCompanyRegisterController {
	
	@Autowired
	private PartnerCompanyRegisterService service;
	
	@PostMapping("register-new-company")
	public ResponseEntity<String> registerNewCompany(@RequestBody @Valid Company company) {
		String accessData = service.registerNewCompany(company);
		return ResponseEntity.ok(accessData);
	}
	
	@PutMapping("update-credentials")
	public ResponseEntity<String> updateCredentials(@RequestParam @Valid Long companyId) {
		String accessData = service.updateCredentials(companyId);
		return ResponseEntity.ok(accessData);
	}

	@PutMapping("register-update-company")
	public ResponseEntity<String> registerUpdateCompany(@RequestBody @Valid Company company) {
		String updated = service.registerUpdateCompany(company);
		return ResponseEntity.ok(updated);
	}
	
	@PutMapping("register-delete-company")
	public ResponseEntity<String> registerDeleteCompany(@RequestBody @Valid  Long companyId) {
		String delete = service.deleteCompany(companyId);
		return ResponseEntity.ok(delete);
	}
}
