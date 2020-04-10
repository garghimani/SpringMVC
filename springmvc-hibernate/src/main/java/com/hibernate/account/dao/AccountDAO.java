package com.hibernate.account.dao;

import com.hibernate.account.vo.AccountVOO;
import com.hibernate.account.vo.AccountValidationException;

public interface AccountDAO {

	AccountVOO getLoginDetails(AccountVOO accountVO) throws AccountValidationException, Exception;

	void addLoginDetails(AccountVOO accountVO) throws AccountValidationException, Exception;

}