package com.nubank.easypay.form;

import com.nubank.easypay.model.AccessData;

public class AccessDataForm {

	private String login;
	
	private String password;

	public AccessDataForm(AccessData accessData) {
		this.login = accessData.getLogin();
		this.password = accessData.getPassword();
	}
	
	public AccessDataForm() {
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
