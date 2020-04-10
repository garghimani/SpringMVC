package com.account.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.dao.AccountDAO;
import com.account.vo.AccountVOO;
import com.account.vo.AccountValidationException;

@Service
public class AccountBOImpl implements AccountBO {

	@Autowired
    AccountDAO accDAO;

	@Override
	public AccountVOO getLoginDetails(AccountVOO accountVO) throws AccountValidationException, Exception {

		AccountVOO accVO = accDAO.getLoginDetails(accountVO);
		return accVO;
	}

	@Override
	public void addLoginDetails(AccountVOO accountVO) throws AccountValidationException, Exception {
		System.out.println("LoginBO : addLoginDetails() : Start");
		accDAO.addLoginDetails(accountVO);
		System.out.println("LoginBO : addLoginDetails() : End");

	}

	

}
