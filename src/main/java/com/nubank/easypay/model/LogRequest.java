package com.nubank.easypay.model;

import java.io.Serializable;

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
	
	

}
