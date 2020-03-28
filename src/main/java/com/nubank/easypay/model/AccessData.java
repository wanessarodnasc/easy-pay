package com.nubank.easypay.model;

public class AccessData {
	
	private String login;
	
	private String password;
	
	public AccessData(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	public AccessData() {
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
