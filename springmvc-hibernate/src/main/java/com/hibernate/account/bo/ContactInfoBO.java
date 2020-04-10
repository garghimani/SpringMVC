package com.hibernate.account.bo;

import com.hibernate.account.vo.AccountValidationException;
import com.hibernate.account.vo.ContactInfoVOO;

public interface ContactInfoBO {

	void addContactInfo(ContactInfoVOO contactVOO) throws AccountValidationException, Exception;

	ContactInfoVOO viewContactInfo(String firstName) throws AccountValidationException, Exception;

	void modifyContactInfo(ContactInfoVOO contactVO) throws AccountValidationException, Exception;

	void deleteContactInfo(String firstName) throws AccountValidationException, Exception;

}