package com.hibernate.account.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.account.dao.ContactInfoDAO;
import com.hibernate.account.vo.AccountValidationException;
import com.hibernate.account.vo.ContactInfoVOO;

@Service
public class ContactInfoBOImpl implements ContactInfoBO {

	@Autowired
	ContactInfoDAO contactDAO;

	
	public void addContactInfo(ContactInfoVOO contactVOO) throws AccountValidationException, Exception {

		System.out.println("ContactInfoBOImpl : addPersonalInfo() : Start");
		contactDAO.addContactInfo(contactVOO);
		System.out.println("ContactInfoBOImpl : addPersonalInfo() : End");

	}

	
	public ContactInfoVOO viewContactInfo(String firstName) throws AccountValidationException, Exception {

		ContactInfoVOO contactVO = contactDAO.viewContactInfo(firstName);
		return contactVO;
	}

	
	public void modifyContactInfo(ContactInfoVOO contactVO) throws AccountValidationException, Exception {

		contactDAO.modifyContactInfo(contactVO);
	}

	
	public void deleteContactInfo(String firstName) throws AccountValidationException, Exception {
		contactDAO.deleteContactInfo(firstName);
	}

}
