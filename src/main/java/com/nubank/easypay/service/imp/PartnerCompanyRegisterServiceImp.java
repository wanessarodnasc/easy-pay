package com.nubank.easypay.service.imp;

import org.springframework.beans.factory.annotation.Autowired;

import com.nubank.easypay.form.AccessDataForm;
import com.nubank.easypay.model.Company;
import com.nubank.easypay.repository.CompanyRepository;
import com.nubank.easypay.service.PartnerCompanyRegisterService;

public class PartnerCompanyRegisterServiceImp implements PartnerCompanyRegisterService {

	@Autowired
	private GenerateCredentials generateCredentials;;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public AccessDataForm registerNewCompany(Company company) {
		AccessDataForm accessData = generateCredentials.generateAccessCredentials(company.getCode());
		saveCompany(company, accessData);
		return accessData;
	}
	
	@Override
	public AccessDataForm updateCredentials(Long companyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String registerUpdateCompany(Long companyId) {
		return null;
	}

	@Override
	public String deleteCompany(Long companyId) {
		return null;
	}

	private void saveCompany(Company company, AccessDataForm accessData) {
		company.setCredentials(criptografyCredentials(accessData));
		companyRepository.save(company);
	}
	
	private String criptografyCredentials(AccessDataForm accessData) {
		// TODO Faca criptografia aqui
		return null;
	}
}
