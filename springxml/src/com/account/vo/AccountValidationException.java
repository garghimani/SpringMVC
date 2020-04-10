package com.account.vo;

/*
 * 
 * User Defined Account Exception
 * 
 * 
 */

public class AccountValidationException extends Exception {
	
	private String errorMessage;

	public AccountValidationException(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	

}
