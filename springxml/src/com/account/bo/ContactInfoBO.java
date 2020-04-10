package com.account.bo;

import com.account.vo.AccountValidationException;
import com.account.vo.ContactInfoVOO;

public interface ContactInfoBO {

	void addContactInfo(ContactInfoVOO contactVOO) throws AccountValidationException, Exception;

	ContactInfoVOO viewContactInfo(String firstName) throws AccountValidationException, Exception;

	void modifyContactInfo(ContactInfoVOO contactVO) throws AccountValidationException, Exception;

	void deleteContactInfo(String firstName) throws AccountValidationException, Exception;

}