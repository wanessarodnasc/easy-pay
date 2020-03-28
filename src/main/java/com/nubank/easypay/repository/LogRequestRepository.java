package com.nubank.easypay.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nubank.easypay.model.LogRequest;

public interface LogRequestRepository extends JpaRepository<LogRequest, Long> {

	Optional<List<LogRequest>> findByCustumerCpf(String cpf);

	Optional<List<LogRequest>> findByCompanyCode(String companyCode);

	Optional<List<LogRequest>> findByStatus(String status);

}
