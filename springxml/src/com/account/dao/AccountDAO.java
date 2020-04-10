package com.account.dao;

import com.account.vo.AccountVOO;
import com.account.vo.AccountValidationException;

public interface AccountDAO {

	AccountVOO getLoginDetails(AccountVOO accountVO) throws AccountValidationException, Exception;

	void addLoginDetails(AccountVOO accountVO) throws AccountValidationException, Exception;

}