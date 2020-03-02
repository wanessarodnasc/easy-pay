package com.nubank.easypay.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nubank.easypay.form.AccessDataForm;
import com.nubank.easypay.model.Company;
import com.nubank.easypay.service.PartnerCompanyRegisterService;

@RestController
public class PartnerCompanyRegisterController {
	
	@Autowired
	private PartnerCompanyRegisterService service;
		
	@PostMapping("register-new-company")
	public ResponseEntity<AccessDataForm> registerNewCompany(@RequestBody @Valid Company company) {
		AccessDataForm accessData = service.registerNewCompany(company);
		return ResponseEntity.ok(accessData);
	}
	
	@PutMapping("update-credentials")
	public ResponseEntity<AccessDataForm> updateCredentials(@RequestBody @Valid Long companyId) {
		AccessDataForm accessData = service.updateCredentials(companyId);
		return ResponseEntity.ok(accessData);
	}

	@PutMapping("register-update-company")
	public ResponseEntity<String> registerUpdateCompany(@RequestBody @Valid Long companyId) {
		String updated = service.registerUpdateCompany(companyId);
		return ResponseEntity.ok(updated);
	}
	
	@PutMapping("register-delete-company")
	public ResponseEntity<String> registerDeleteCompany(@RequestBody @Valid  Long companyId) {
		String delete = service.deleteCompany(companyId);
		return ResponseEntity.ok(delete);
	}
}