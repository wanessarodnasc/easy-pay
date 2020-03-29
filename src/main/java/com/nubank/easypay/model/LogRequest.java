package com.nubank.easypay.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "log_request")
public class LogRequest implements Serializable {

	private static final long serialVersionUID = -3720729525176684696L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "custumer_cpf", nullable = false)
	private String custumerCpf;
	
	@Column(name = "company_code" , nullable = false)
	private String companyCode;
	
	@Column(name = "status")
	private String status;
	
	@DateTimeFormat
	@Column(name = "data_time_start", nullable = false)
	private LocalDateTime dataTimeStart;

	@DateTimeFormat
	@Column(name = "data_time_start_end")
	private LocalDateTime dataTimeEnd;

	public LogRequest() {
	}
	
	public LogRequest(String custumerCpf, String companyCode, String status, LocalDateTime dataTimeStart,
			LocalDateTime dataTimeEnd) {
		this.custumerCpf = custumerCpf;
		this.companyCode = companyCode;
		this.status = status;
		this.dataTimeStart = dataTimeStart;
		this.dataTimeEnd = dataTimeEnd;
	}

	public LogRequest(String custumerCpf, String companyCode, LocalDateTime dataTimeStart) {
		this.custumerCpf = custumerCpf;
		this.companyCode = companyCode;
		this.dataTimeStart = dataTimeStart;
	}

	public LogRequest(String custumerCpf, String companyCode) {
		this.custumerCpf = custumerCpf;
		this.companyCode = companyCode;
	}

	public String getCustumerCpf() {
		return custumerCpf;
	}

	public void setCustumerCpf(String custumerCpf) {
		this.custumerCpf = custumerCpf;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getDataTimeStart() {
		return dataTimeStart;
	}

	public void setDataTimeStart(LocalDateTime dataTimeStart) {
		this.dataTimeStart = dataTimeStart;
	}

	public LocalDateTime getDataTimeEnd() {
		return dataTimeEnd;
	}

	public void setDataTimeEnd(LocalDateTime dataTimeEnd) {
		this.dataTimeEnd = dataTimeEnd;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
