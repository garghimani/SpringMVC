package com.account.dao;

import org.springframework.stereotype.Repository;

import com.account.db.ContactInfoDB;
import com.account.validation.AccountValidation;
import com.account.vo.AccountValidationException;
import com.account.vo.ContactInfoVOO;

@Repository
public class ContactInfoDAOImpl implements ContactInfoDAO {

	@Override
	public void addContactInfo(ContactInfoVOO contactVOO) throws AccountValidationException, Exception {

		System.out.println("ContactInfoDAOImpl : addContactInfo() : Start");
		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		System.out.println("Inside AccountBO : " + contactVOO.getAddress());
		allMessages.append(accValidate.validateContactDetails(contactVOO.getAddress(), contactVOO.getCity(),
				contactVOO.getState(), contactVOO.getCountry(), contactVOO.getPhone(), contactVOO.getPersonID()));
		System.out.println("BO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In BO : " + contactVOO.getAddress());
			ContactInfoDB contactDB = new ContactInfoDB();
			contactDB.addContactInfo(contactVOO.getAddress(), contactVOO.getCity(),
				contactVOO.getState(), contactVOO.getCountry(), contactVOO.getPhone(), contactVOO.getPersonID());
			System.out.println("ContactInfoDAOImpl : addContactInfo() : End");
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
	}
	
	@Override
	public ContactInfoVOO viewContactInfo(String firstName) throws AccountValidationException, Exception {

		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		ContactInfoVOO contactVO = null;
		System.out.println("Inside AccountBO : " + firstName);
		allMessages.append(accValidate.validateFirstName(firstName));
		System.out.println("BO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In BO : " + firstName);
			ContactInfoDB contactDB = new ContactInfoDB();
			contactVO = contactDB.getContactInfo(firstName) ;
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
		return contactVO;
	}
	
	@Override
	public void modifyContactInfo(ContactInfoVOO contactVO) throws AccountValidationException, Exception {

		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		System.out.println("Inside AccountBO : " + contactVO.getPersonID());
		allMessages.append(accValidate.validateFirstName(contactVO.getPersonID()));
		System.out.println("BO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In BO : " + contactVO.getPersonID());
			ContactInfoDB contactDB = new ContactInfoDB();
			contactDB.updateContactInfo(contactVO);
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
	}
	
	@Override
	public void deleteContactInfo(String firstName) throws AccountValidationException, Exception {

		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		System.out.println("Inside AccountBO : " + firstName);
		allMessages.append(accValidate.validateFirstName(firstName));
		System.out.println("BO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In BO : " + firstName);
			ContactInfoDB contactDB = new ContactInfoDB();
			contactDB.deleteContactInfo(firstName);
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
	}

}
