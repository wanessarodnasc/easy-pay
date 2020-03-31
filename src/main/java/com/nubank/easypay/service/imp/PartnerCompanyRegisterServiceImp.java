package com.nubank.easypay.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nubank.easypay.enumeration.RegisterEnum;
import com.nubank.easypay.exception.BussinessException;
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
		try {
			Optional<Company> companyExist = companyRepository.findByCode(company.getCode());
			if (companyExist.isPresent()) {
				return RegisterEnum.DUPLICATED.getDescription();
			}
			AccessData accessData = generateCredentials.generateAccessCredentials(company.getCode());
			return saveCompany(new Company(company), accessData);
		} catch (Exception e) {
			return RegisterEnum.SAVE_UPDATE_ERROR.getDescription();
		}
	}

	@Override
	public String updateCredentials(String companyCode) {
		Optional<Company> company = companyRepository.findByCode(companyCode);
		AccessData accessData = generateCredentials.generateAccessCredentials(company.get().getCode());
		return saveCompany(company.get(), accessData);
	}

	@Override
	public String registerUpdateCompany(CompanyUpdateForm companyForm) {
		try {
			Company company = getCompany(companyForm.getCode());
			company.setAddress(new Address(companyForm.getAddress()));
			companyRepository.save(company);
			return RegisterEnum.UPDATED.getDescription();
		} catch (Exception e) {
			return RegisterEnum.SAVE_UPDATE_ERROR.getDescription();
		}
	}

	@Override
	public String deleteCompany(String companyCode) {
		try {
			Company company = getCompany(companyCode);
			company.setStatus(false);
			companyRepository.saveAndFlush(company);
		} catch (Exception e) {
			return RegisterEnum.DOES_NOT_FOUND.getDescription();
		}
		return RegisterEnum.DELETED.getDescription();
	}


	private String saveCompany(Company company, AccessData accessData) {
		try {
			company.setCredentials(accessData.getLogin().concat(":").concat(accessData.getPassword()));
			company.setStatus(true);
			Company companySaved = companyRepository.save(company);
			if (companySaved == null) {
				return RegisterEnum.SAVE_UPDATE_ERROR.getDescription();
			}
		} catch (Exception e) {
			return RegisterEnum.SAVE_UPDATE_ERROR.getDescription();
		}
		return RegisterEnum.SAVED.getDescription();
	}

	private Company getCompany(String companyCode) throws BussinessException {
		Optional<Company> company = companyRepository.findByCode(companyCode);
		if (!company.isPresent()) {
			throw new BussinessException(RegisterEnum.DOES_NOT_FOUND.getDescription());
		}
		return company.get();
	}
}
