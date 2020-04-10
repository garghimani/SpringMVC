package com.hibernate.account.bo;

import com.hibernate.account.vo.AccountValidationException;
import com.hibernate.account.vo.PersonalInfoVOO;

public interface PersonalInfoBO {

	void addPersonalInfo(PersonalInfoVOO personalVOO) throws AccountValidationException, Exception;

	PersonalInfoVOO viewPersonalInfo(String firstName) throws AccountValidationException, Exception;

	void modifyPersonalInfo(PersonalInfoVOO personalVOO) throws AccountValidationException, Exception;

	void deletePersonalInfo(String firstName) throws AccountValidationException, Exception;

}