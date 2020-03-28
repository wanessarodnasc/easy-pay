package com.nubank.easypay.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nubank.easypay.form.CompanyInsertForm;
import com.nubank.easypay.form.CompanyUpdateForm;
import com.nubank.easypay.model.AccessData;
import com.nubank.easypay.model.Address;
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
	public String registerNewCompany(CompanyInsertForm company) {
		Optional<Company> companyExist = companyRepository.findByCode(company.getCode());
		if(companyExist.isPresent()) {
			return "Company alredy registered.";
		}
		AccessData accessData = generateCredentials.generateAccessCredentials(company.getCode());
		return saveCompany(new Company(company), accessData);
	}
	
	@Override
	public String updateCredentials(String companyCode) {
		Optional<Company> company = companyRepository.findByCode(companyCode);
		AccessData accessData = generateCredentials.generateAccessCredentials(company.get().getCode());
		return saveCompany(company.get(), accessData);
	}

	@Override
	public String registerUpdateCompany(CompanyUpdateForm company) {
		try {
			Optional<Company> companyExist = companyRepository.findByCode(company.getCode());
			if(companyExist.isPresent()) {
				companyExist.get().setAddress(new Address(company.getAddress()));
				companyRepository.saveAndFlush(companyExist.get());
				return "Company updated.";
			}
			
		} catch (Exception e) {
			return "Was not possible save the company";
		}
		return "Was not possible save the company"; 
	}

	@Override
	public String deleteCompany(String companyCode) {
		try {
			Optional<Company> company = companyRepository.findByCode(companyCode);
			if(company.isPresent()) {
				company.get().setStatus(false);
				companyRepository.saveAndFlush(company.get());
				return "Company deleted sucessufully.";
			}
			
		} catch (Exception e) {
			return "Company not found";
		}
		return "Was not possible delete the company"; 
	}

	private String saveCompany(Company company, AccessData accessData) {
		try {
			company.setCredentials(accessData.getLogin().concat(":").concat(accessData.getPassword()));
			company.setStatus(true);
			Company companySaved  = companyRepository.save(company);
			if(companySaved != null) {
				return "Company saved/updated";
			}
		} catch (Exception e) {
			return "Was not possible save/updated the company";
		}
		return "Was not possible save/updated the company";
	}
}
