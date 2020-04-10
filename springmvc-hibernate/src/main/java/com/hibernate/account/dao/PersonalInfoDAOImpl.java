package com.hibernate.account.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.hibernate.account.util.HibernateUtil;
import com.hibernate.account.validation.AccountValidation;
import com.hibernate.account.vo.AccountValidationException;
import com.hibernate.account.vo.PersonalInfoVOO;

@Repository
public class PersonalInfoDAOImpl implements PersonalInfoDAO {

	public PersonalInfoDAOImpl() {
		super();
	}


	public void addPersonalInfo(PersonalInfoVOO personalVOO) throws AccountValidationException, Exception {

		System.out.println("PersonalInfoDAOImpl : addPersonalInfo() : Start");
		Session session = HibernateUtil.getSessionFactory().openSession();
		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		System.out.println("Inside AccountBO : " + personalVOO.getFirstName());
		allMessages.append(accValidate.validatePersonalDetails(personalVOO.getFirstName(), personalVOO.getMiddleName(),
				personalVOO.getLastName(), personalVOO.getGender()));
		System.out.println("BO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In BO : " + personalVOO.getFirstName());
			Transaction tx = session.getTransaction();
			tx.begin();
			session.save(personalVOO);
			System.out.println("PersonalInfoDAOImpl : addPersonalInfo() : End");
			tx.commit();
			session.close();
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
	}
	

	public PersonalInfoVOO viewPersonalInfo(String firstName) throws AccountValidationException, Exception {

		Session session = HibernateUtil.getSessionFactory().openSession();
		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		PersonalInfoVOO personalVO = null;
		System.out.println("Inside AccountBO : " + firstName);
		allMessages.append(accValidate.validateFirstName(firstName));
		System.out.println("BO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In BO : " + firstName);
			personalVO = (PersonalInfoVOO)session.load(PersonalInfoVOO.class, firstName);
			System.out.println(personalVO);
			session.close();
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
		return personalVO;
	}
	

	public void modifyPersonalInfo(PersonalInfoVOO personalVOO) throws AccountValidationException, Exception {

		Session session = HibernateUtil.getSessionFactory().openSession();
		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		System.out.println("Inside AccountBO : " + personalVOO.getFirstName());
		allMessages.append(accValidate.validateFirstName(personalVOO.getFirstName()));
		System.out.println("BO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In BO : " + personalVOO.getFirstName());
			Transaction tx = session.getTransaction();
			tx.begin();
			session.update(personalVOO);
			tx.commit();
			session.close();
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
	}
	

	public void deletePersonalInfo(String firstName) throws AccountValidationException, Exception {

		Session session = HibernateUtil.getSessionFactory().openSession();
		StringBuffer allMessages = new StringBuffer();
		AccountValidation accValidate = new AccountValidation();
		System.out.println("Inside AccountBO : " + firstName);
		allMessages.append(accValidate.validateFirstName(firstName));
		System.out.println("BO Messages :" + allMessages.toString());
		if (allMessages.length() == 0) {
			System.out.println("In BO : " + firstName);
			PersonalInfoVOO personalVO = viewPersonalInfo(firstName);
			Transaction tx = session.getTransaction();
			tx.begin();
			session.delete(personalVO);
			tx.commit();
			session.close();
		} else {
			throw new AccountValidationException(allMessages.toString());
		}
	}

}
