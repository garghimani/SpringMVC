package com.account.bo;

import com.account.vo.AccountVOO;
import com.account.vo.AccountValidationException;

public interface AccountBO {

	AccountVOO getLoginDetails(AccountVOO accountVO) throws AccountValidationException, Exception;

	void addLoginDetails(AccountVOO accountVO) throws AccountValidationException, Exception;

}