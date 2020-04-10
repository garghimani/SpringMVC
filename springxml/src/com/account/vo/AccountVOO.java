package com.account.vo;
/*
 * 
 * 
 * Account Bean
 * 
 * 
 */
public class AccountVOO {
	
	private String userName;
	private String passwd;

	//No Argument Constructor
	public AccountVOO() {
		super();
	}
	
	//Argument Constructor
	public AccountVOO(String userName, String passwd) {
		this.userName = userName;
		this.passwd = passwd;
	}

	//Getters
	public String getUserName() {
		return userName;
	}
	
	public String getPasswd() {
		return passwd;
	}

	
	//Setters
	public void setUserName(String userName) {
		this.userName = userName;
	}	

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}
