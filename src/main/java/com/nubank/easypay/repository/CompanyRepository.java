package com.nubank.easypay.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nubank.easypay.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

	Optional<Company> findByCode(String code);

}
