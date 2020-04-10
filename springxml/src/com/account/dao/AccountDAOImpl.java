package com.account.dao;

import org.springframework.stereotype.Repository;

import com.account.db.LoginDB;
import com.account.validation.AccountValidation;
import com.account.vo.AccountVOO;
import com.account.vo.AccountValidationException;

@Repository
public class AccountDAOImpl implements AccountDAO {
	
	@Override
	public AccountVOO getLoginDetails(AccountVOO accountVO)throws AccountValidationException, Exception {
		
		AccountVOO accVO = null;
		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		allMessages.append(accValidate.validateUserName(accountVO.getUserName()));
		allMessages.append(accValidate.validatePassword(accountVO.getPasswd()));
		if (allMessages.length() == 0) {
			//retrieving database record
			LoginDB loginDB = new LoginDB();
			accVO = loginDB.getLoginInfo(accountVO.getUserName(), accountVO.getPasswd());
		}
		else {
			throw new AccountValidationException(allMessages.toString());
		}
		return accVO;
	}
	
	@Override
	public void addLoginDetails(AccountVOO accountVO)throws AccountValidationException, Exception{
		
		System.out.println("LoginDAO : addLoginDetails() : Start");
		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		System.out.println("Inside AccountDAO : "+accountVO.getUserName()+"  "+accountVO.getPasswd());
		allMessages.append(accValidate.validateUserName(accountVO.getUserName()));
		allMessages.append(accValidate.validatePassword(accountVO.getPasswd()));
		System.out.println("BO Messages :"+allMessages.toString());
		if(allMessages.length() == 0) {
			System.out.println("In BO : "+accountVO.getUserName()+"  "+accountVO.getPasswd());
			LoginDB loginDB = new LoginDB();
			loginDB.addLoginInfo(accountVO.getUserName(), accountVO.getPasswd());
			System.out.println("LoginDAO : addLoginDetails() : End");
		}
		else {
			throw new AccountValidationException(allMessages.toString());
		}
	}

}
