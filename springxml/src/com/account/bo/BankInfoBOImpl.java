package com.account.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.dao.BankInfoDAO;
import com.account.vo.AccountValidationException;
import com.account.vo.BankInfoVOO;

@Service
public class BankInfoBOImpl implements BankInfoBO {

	@Autowired
	BankInfoDAO bankDAO;

	@Override
	public void addBankInfo(BankInfoVOO bankVOO) throws AccountValidationException, Exception {
		System.out.println("BankInfoBOImpl : addPersonalInfo() : Start");
		bankDAO.addBankInfo(bankVOO);
		System.out.println("BankInfoBOImpl : addPersonalInfo() : End");
	}

	@Override
	public BankInfoVOO viewBankInfo(String firstName) throws AccountValidationException, Exception {
		
		BankInfoVOO bankVO = bankDAO.viewBankInfo(firstName);
		return bankVO;
	}

	@Override
	public void modifyBankInfo(BankInfoVOO modifybankVOO) throws AccountValidationException, Exception {
		
		bankDAO.modifyBankInfo(modifybankVOO);

	}

	@Override
	public void deleteBankInfo(String firstName) throws AccountValidationException, Exception {

		bankDAO.deleteBankInfo(firstName);
		
	}

}
