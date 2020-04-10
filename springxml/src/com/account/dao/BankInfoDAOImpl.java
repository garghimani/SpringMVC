package com.account.dao;

import org.springframework.stereotype.Repository;

import com.account.db.BankInfoDB;
import com.account.validation.AccountValidation;
import com.account.vo.AccountValidationException;
import com.account.vo.BankInfoVOO;

@Repository
public class BankInfoDAOImpl implements BankInfoDAO {

	@Override
	public void addBankInfo(BankInfoVOO bankVOO) throws AccountValidationException, Exception {

		System.out.println("BankInfoDAOImpl : addPersonalInfo() : Start");
		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		System.out.println("Inside AccountBO : " + bankVOO.getBankName());
		allMessages.append(accValidate.validateBankDetails(bankVOO.getBankName(), bankVOO.getAccountNumber(),
				bankVOO.getSsn(), bankVOO.getPersonId()));
		System.out.println("BO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In BO : " + bankVOO.getBankName());
			BankInfoDB bankDB = new BankInfoDB();
			bankDB.addBankInfo(bankVOO.getBankName(), bankVOO.getAccountNumber(),
				bankVOO.getSsn(), bankVOO.getPersonId());
			System.out.println("BankInfoDAOImpl : addPersonalInfo() : End");
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
	}
	
	@Override
	public BankInfoVOO viewBankInfo(String firstName) throws AccountValidationException, Exception {

		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		BankInfoVOO bankVO = null;
		System.out.println("Inside AccountBO : " + firstName);
		allMessages.append(accValidate.validateFirstName(firstName));
		System.out.println("BO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In BO : " + firstName);
			BankInfoDB bankDB = new BankInfoDB();
			bankVO = bankDB.getBankInfo(firstName);
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
		return bankVO;
	}
	
	@Override
	public void modifyBankInfo(BankInfoVOO modifybankVOO) throws AccountValidationException, Exception {

		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		System.out.println("Inside AccountBO : " + modifybankVOO.getPersonId());
		allMessages.append(accValidate.validateFirstName(modifybankVOO.getPersonId()));
		System.out.println("BO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In BO : " + modifybankVOO.getPersonId());
			BankInfoDB bankDB = new BankInfoDB();
			bankDB.updateBankInfo(modifybankVOO);
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
	}
	
	@Override
	public void deleteBankInfo(String firstName) throws AccountValidationException, Exception {

		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		System.out.println("Inside AccountBO : " + firstName);
		allMessages.append(accValidate.validateFirstName(firstName));
		System.out.println("BO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In BO : " + firstName);
			BankInfoDB bankDB = new BankInfoDB();
			bankDB.deleteBankInfo(firstName);
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
	}

}
