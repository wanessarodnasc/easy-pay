package com.nubank.easypay.service;

import com.nubank.easypay.form.CompanyInsertForm;
import com.nubank.easypay.form.CompanyUpdateForm;

public interface PartnerCompanyRegisterService {

	String registerNewCompany(CompanyInsertForm company);

	String registerUpdateCompany(CompanyUpdateForm company);

	String updateCredentials(String companyCode);

	String deleteCompany(String companyCode);

}
