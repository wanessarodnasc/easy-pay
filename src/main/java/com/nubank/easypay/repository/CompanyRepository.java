package com.nubank.easypay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nubank.easypay.model.Company;

public interface CompanyRepository  extends JpaRepository<Company, Long> {


}
