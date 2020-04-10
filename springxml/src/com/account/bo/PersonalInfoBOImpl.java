package com.account.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.dao.PersonalInfoDAO;
import com.account.vo.AccountValidationException;
import com.account.vo.PersonalInfoVOO;

@Service
public class PersonalInfoBOImpl implements PersonalInfoBO {

	@Autowired
	PersonalInfoDAO personDAO;

	@Override
	public void addPersonalInfo(PersonalInfoVOO personalVOO) throws AccountValidationException, Exception {

		System.out.println("PersonalInfoBOImpl : addPersonalInfo() : Start");
		personDAO.addPersonalInfo(personalVOO);
		System.out.println("PersonalInfoBOImpl : addPersonalInfo() : End");

	}

	@Override
	public PersonalInfoVOO viewPersonalInfo(String firstName) throws AccountValidationException, Exception {

		PersonalInfoVOO personaVO = personDAO.viewPersonalInfo(firstName);
		return personaVO;
	}

	@Override
	public void modifyPersonalInfo(PersonalInfoVOO personalVOO) throws AccountValidationException, Exception {

		personDAO.modifyPersonalInfo(personalVOO);

	}

	@Override
	public void deletePersonalInfo(String firstName) throws AccountValidationException, Exception {

		personDAO.deletePersonalInfo(firstName);
	}

}
