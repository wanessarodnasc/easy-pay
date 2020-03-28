package com.nubank.easypay.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "log_request")
public class LogRequest implements Serializable {

	private static final long serialVersionUID = -3720729525176684696L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "custumer_cpf")
	private String custumerCpf;
	
	@Column(name = "company_code")
	private String companyCode;
	
	@Column(name = "status", nullable = false)
	private String status;
	
	@Column(name = "data_time", nullable = false)
	private LocalDateTime dataTime;
	
	public LogRequest() {
	}
	
	public LogRequest(String custumerCpf, String companyCode, String status, LocalDateTime dataTime) {
		this.custumerCpf = custumerCpf;
		this.companyCode = companyCode;
		this.status = status;
		this.dataTime = dataTime;
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

	public LocalDateTime getDataTime() {
		return dataTime;
	}

	public void setDataTime(LocalDateTime dataTime) {
		this.dataTime = dataTime;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "LogRequest [custumerCpf=" + custumerCpf + ", companyCode=" + companyCode + ", status=" + status
				+ ", dataTime=" + dataTime + "]";
	}
}
