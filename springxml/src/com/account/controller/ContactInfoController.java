package com.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.account.bo.ContactInfoBO;
import com.account.vo.ContactInfoVOO;
import com.account.vo.PersonalInfoVOO;

@Controller
@SessionAttributes({"address","city","state","country","phone"})
public class ContactInfoController {
	@Autowired
	ContactInfoBO contactBO;

	@RequestMapping("/entryAddContactDetails.do")
	public String entryAddContactDetails(@ModelAttribute ContactInfoVOO addContactVOO) {
		System.out.println("AddContactInfo Controller : entryAddContactDetails() : Start");
		System.out.println("AddContactInfo Controller : entryAddContactDetails() : End");
		return "contactinfo3";
	}

	//Create Contact Details
	@RequestMapping("/processAddContactDetails.do")
	public String processAddContactDetails(Model model, ContactInfoVOO addContactVOO ) throws Exception {
		System.out.println("AddContactInfo : processAddContactDetails() : Start");
		System.out.println("Address : " + addContactVOO.getAddress());
		
		model.addAttribute("address", addContactVOO.getAddress());
		model.addAttribute("city", addContactVOO.getCity());
		model.addAttribute("state", addContactVOO.getState());
		model.addAttribute("country", addContactVOO.getCountry());
		model.addAttribute("phone", addContactVOO.getPhone());
		try {
			contactBO.addContactInfo(addContactVOO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("AddContactInfo : processAddContactDetails() : End");
		return "bankinfo3";
	}
	
	//Retrieve Contact Details for the given FirstName  
    @RequestMapping(value="/viewContactDetails.do")    
    public String processViewContactDetails(Model model,@ModelAttribute ContactInfoVOO viewContactVOO){  
    	System.out.println("viewContactDetails : processViewContactDetails() : Start");
		try {
    	viewContactVOO = contactBO.viewContactInfo(viewContactVOO.getPersonID());
    	System.out.println("First Name : " + viewContactVOO.getPersonID());
        model.addAttribute("viewContactVOO",viewContactVOO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("viewContactDetails : processViewContactDetails() : End");
        return "viewcontactdetailssuccess";    
    }    
    
    //Update Contact Details for the given FirstName
    @RequestMapping("/modifyContactDetails.do")
	public String processContactPersonalDetails(@ModelAttribute ContactInfoVOO modifyContactVOO, Model model) throws Exception {
		System.out.println("modifyContactDetails : processContactPersonalDetails() : Start");

		System.out.println("FirstName : " + modifyContactVOO.getPersonID());
		try {
			contactBO.modifyContactInfo(modifyContactVOO);
			modifyContactVOO = contactBO.viewContactInfo(modifyContactVOO.getPersonID());
			model.addAttribute("viewContactVOO",modifyContactVOO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("modifyContactDetails : processContactPersonalDetails() : End");
		return "viewcontactdetailssuccess";
	}
    
    //Delete ContactDetails on the basis of FirstName
    @RequestMapping("/deleteContactDetails.do")
   	public String processDeleteContactDetails(@ModelAttribute ContactInfoVOO deleteContactVOO) throws Exception {
   		System.out.println("deleteContactDetails : processDeleteContactDetails() : Start");

   		System.out.println("FirstName : " + deleteContactVOO.getPersonID());
   		try {
   			contactBO.deleteContactInfo(deleteContactVOO.getPersonID());
   		} catch (Exception e) {
   			e.printStackTrace();
   		}
   		System.out.println("deleteContactDetails : processDeleteContactDetails() : End");
   		return "deletesuccess";
   	}

}
