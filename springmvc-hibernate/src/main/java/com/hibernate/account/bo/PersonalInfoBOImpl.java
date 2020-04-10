package com.hibernate.account.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.account.dao.PersonalInfoDAO;
import com.hibernate.account.vo.AccountValidationException;
import com.hibernate.account.vo.PersonalInfoVOO;

@Service
public class PersonalInfoBOImpl implements PersonalInfoBO {

	@Autowired
	PersonalInfoDAO personDAO;

	
	public void addPersonalInfo(PersonalInfoVOO personalVOO) throws AccountValidationException, Exception {

		System.out.println("PersonalInfoBOImpl : addPersonalInfo() : Start");
		personDAO.addPersonalInfo(personalVOO);
		System.out.println("PersonalInfoBOImpl : addPersonalInfo() : End");

	}

	
	public PersonalInfoVOO viewPersonalInfo(String firstName) throws AccountValidationException, Exception {

		PersonalInfoVOO personaVO = personDAO.viewPersonalInfo(firstName);
		return personaVO;
	}

	
	public void modifyPersonalInfo(PersonalInfoVOO personalVOO) throws AccountValidationException, Exception {

		personDAO.modifyPersonalInfo(personalVOO);

	}

	
	public void deletePersonalInfo(String firstName) throws AccountValidationException, Exception {

		personDAO.deletePersonalInfo(firstName);
	}

}
