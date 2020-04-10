package com.hibernate.account.dao;

import com.hibernate.account.vo.AccountValidationException;
import com.hibernate.account.vo.ContactInfoVOO;

public interface ContactInfoDAO {

	void addContactInfo(ContactInfoVOO contactVOO) throws AccountValidationException, Exception;

	ContactInfoVOO viewContactInfo(String firstName) throws AccountValidationException, Exception;

	void modifyContactInfo(ContactInfoVOO contactVO) throws AccountValidationException, Exception;

	void deleteContactInfo(String firstName) throws AccountValidationException, Exception;

}