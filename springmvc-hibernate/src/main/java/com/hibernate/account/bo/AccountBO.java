package com.hibernate.account.bo;

import com.hibernate.account.vo.AccountVOO;
import com.hibernate.account.vo.AccountValidationException;

public interface AccountBO {

	AccountVOO getLoginDetails(AccountVOO accountVO) throws AccountValidationException, Exception;

	void addLoginDetails(AccountVOO accountVO) throws AccountValidationException, Exception;

}