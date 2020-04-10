package com.account.dao;

import org.springframework.stereotype.Repository;

import com.account.db.PersonalInfoDB;
import com.account.validation.AccountValidation;
import com.account.vo.AccountValidationException;
import com.account.vo.PersonalInfoVOO;

@Repository
public class PersonalInfoDAOImpl implements PersonalInfoDAO {

	public PersonalInfoDAOImpl() {
		super();
	}

	@Override
	public void addPersonalInfo(PersonalInfoVOO personalVOO) throws AccountValidationException, Exception {

		System.out.println("PersonalInfoDAOImpl : addPersonalInfo() : Start");
		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		System.out.println("Inside AccountBO : " + personalVOO.getFirstName());
		allMessages.append(accValidate.validatePersonalDetails(personalVOO.getFirstName(), personalVOO.getMiddleName(),
				personalVOO.getLastName(), personalVOO.getGender()));
		System.out.println("BO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In BO : " + personalVOO.getFirstName());
			PersonalInfoDB personalDB = new PersonalInfoDB();
			personalDB.addPersonalInfo(personalVOO.getFirstName(), personalVOO.getMiddleName(),
				personalVOO.getLastName(), personalVOO.getGender());
			System.out.println("PersonalInfoDAOImpl : addPersonalInfo() : End");
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
	}
	
	@Override
	public PersonalInfoVOO viewPersonalInfo(String firstName) throws AccountValidationException, Exception {

		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		PersonalInfoVOO personaVO = null;
		System.out.println("Inside AccountBO : " + firstName);
		allMessages.append(accValidate.validateFirstName(firstName));
		System.out.println("BO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In BO : " + firstName);
			PersonalInfoDB personalDB = new PersonalInfoDB();
			personaVO = personalDB.getPersonalInfo(firstName);
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
		return personaVO;
	}
	
	@Override
	public void modifyPersonalInfo(PersonalInfoVOO personalVOO) throws AccountValidationException, Exception {

		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		System.out.println("Inside AccountBO : " + personalVOO.getFirstName());
		allMessages.append(accValidate.validateFirstName(personalVOO.getFirstName()));
		System.out.println("BO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In BO : " + personalVOO.getFirstName());
			PersonalInfoDB personalDB = new PersonalInfoDB();
			personalDB.updatePersonalInfo(personalVOO);
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
	}
	
	@Override
	public void deletePersonalInfo(String firstName) throws AccountValidationException, Exception {

		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		System.out.println("Inside AccountBO : " + firstName);
		allMessages.append(accValidate.validateFirstName(firstName));
		System.out.println("BO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In BO : " + firstName);
			PersonalInfoDB personalDB = new PersonalInfoDB();
			personalDB.deletePersonalInfo(firstName);
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
	}

}
