package com.account.dao;

import com.account.vo.AccountValidationException;
import com.account.vo.PersonalInfoVOO;

public interface PersonalInfoDAO {

	void addPersonalInfo(PersonalInfoVOO personalVOO) throws AccountValidationException, Exception;

	PersonalInfoVOO viewPersonalInfo(String firstName) throws AccountValidationException, Exception;

	void modifyPersonalInfo(PersonalInfoVOO personalVOO) throws AccountValidationException, Exception;

	void deletePersonalInfo(String firstName) throws AccountValidationException, Exception;

}