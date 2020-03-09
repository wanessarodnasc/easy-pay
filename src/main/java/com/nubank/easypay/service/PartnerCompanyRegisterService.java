package com.nubank.easypay.service;

import com.nubank.easypay.model.Company;

public interface PartnerCompanyRegisterService {

	String registerNewCompany(Company company);

	String registerUpdateCompany(Long companyId);

	String updateCredentials(Long companyId);

	String deleteCompany(Long companyId);

}
