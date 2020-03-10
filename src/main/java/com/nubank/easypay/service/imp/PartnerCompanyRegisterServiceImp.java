package com.nubank.easypay.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nubank.easypay.model.AccessData;
import com.nubank.easypay.model.Company;
import com.nubank.easypay.repository.CompanyRepository;
import com.nubank.easypay.service.PartnerCompanyRegisterService;

@Service
public class PartnerCompanyRegisterServiceImp implements PartnerCompanyRegisterService {

	@Autowired
	private GenerateCredentials generateCredentials;;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public String registerNewCompany(Company company) {
		AccessData accessData = generateCredentials.generateAccessCredentials(company.getCode());
		return saveCompany(company, accessData);
	}
	
	@Override
	public String updateCredentials(Long companyId) {
		Optional<Company> company = companyRepository.findById(companyId);
		AccessData accessData = generateCredentials.generateAccessCredentials(company.get().getCode());
		return saveCompany(company.get(), accessData);
	}

	@Override
	public String registerUpdateCompany(Company company) {
		try {
			Optional<Company> oldCompany = companyRepository.findById(company.getId());
			if(oldCompany.isPresent()) {
				companyRepository.saveAndFlush(company);
				return "OK";
			}
			
		} catch (Exception e) {
			return "Was not possible save the company";
		}
		return "Was not possible save the company"; 
	}

	@Override
	public String deleteCompany(Long companyId) {
		try {
			Optional<Company> company = companyRepository.findById(companyId);
			if(company.isPresent()) {
				company.get().setStatus(false);
				companyRepository.saveAndFlush(company.get());
				return "OK";
			}
			
		} catch (Exception e) {
			return "Company not found";
		}
		return "Was not possible save the company"; 
	}

	private String saveCompany(Company company, AccessData accessData) {
		try {
			company.setCredentials(accessData.getLogin().concat(":").concat(accessData.getPassword()));
			company.setStatus(true);
			Company companySaved  = companyRepository.save(company);
			if(companySaved == null) {
				return "Company saved";
			}
		} catch (Exception e) {
			return "Was not possible save the company";
		}
		return "Was not possible save the company";
	}
}
