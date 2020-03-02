package com.nubank.easypay.service;

import com.nubank.easypay.form.AccessDataForm;
import com.nubank.easypay.model.Company;

public interface PartnerCompanyRegisterService {

	AccessDataForm registerNewCompany(Company company);

	String registerUpdateCompany(Long companyId);

	AccessDataForm updateCredentials(Long companyId);

	String deleteCompany(Long companyId);

}
