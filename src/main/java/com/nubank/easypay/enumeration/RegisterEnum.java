package com.nubank.easypay.enumeration;

public enum RegisterEnum {
	
	DUPLICATED("Register alredy registered."),
	UPDATED("Register updated."),
	DOES_NOT_FOUND("Register does not found."),
	DELETED("Register deleted sucessufully."),
	SAVED("Register saved/updated sucessufully."),
	SAVE_UPDATE_ERROR("Erro to save/update register.");
	
	private String description;

	private RegisterEnum(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
