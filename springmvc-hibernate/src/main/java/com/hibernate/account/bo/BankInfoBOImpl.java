package com.hibernate.account.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.account.dao.BankInfoDAO;
import com.hibernate.account.vo.AccountValidationException;
import com.hibernate.account.vo.BankInfoVOO;

@Service
public class BankInfoBOImpl implements BankInfoBO {

	@Autowired
	BankInfoDAO bankDAO;


	public void addBankInfo(BankInfoVOO bankVOO) throws AccountValidationException, Exception {
		System.out.println("BankInfoBOImpl : addPersonalInfo() : Start");
		bankDAO.addBankInfo(bankVOO);
		System.out.println("BankInfoBOImpl : addPersonalInfo() : End");
	}


	public BankInfoVOO viewBankInfo(String firstName) throws AccountValidationException, Exception {
		
		BankInfoVOO bankVO = bankDAO.viewBankInfo(firstName);
		return bankVO;
	}

	
	public void modifyBankInfo(BankInfoVOO modifybankVOO) throws AccountValidationException, Exception {
		
		bankDAO.modifyBankInfo(modifybankVOO);

	}

	
	public void deleteBankInfo(String firstName) throws AccountValidationException, Exception {

		bankDAO.deleteBankInfo(firstName);
		
	}

}
