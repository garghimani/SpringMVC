package com.account.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.dao.ContactInfoDAO;
import com.account.vo.AccountValidationException;
import com.account.vo.ContactInfoVOO;

@Service
public class ContactInfoBOImpl implements ContactInfoBO {

	@Autowired
	ContactInfoDAO contactDAO;

	@Override
	public void addContactInfo(ContactInfoVOO contactVOO) throws AccountValidationException, Exception {

		System.out.println("ContactInfoBOImpl : addPersonalInfo() : Start");
		contactDAO.addContactInfo(contactVOO);
		System.out.println("ContactInfoBOImpl : addPersonalInfo() : End");

	}

	@Override
	public ContactInfoVOO viewContactInfo(String firstName) throws AccountValidationException, Exception {

		ContactInfoVOO contactVO = contactDAO.viewContactInfo(firstName);
		return contactVO;
	}

	@Override
	public void modifyContactInfo(ContactInfoVOO contactVO) throws AccountValidationException, Exception {

		contactDAO.modifyContactInfo(contactVO);
	}

	@Override
	public void deleteContactInfo(String firstName) throws AccountValidationException, Exception {
		contactDAO.deleteContactInfo(firstName);
	}

}
