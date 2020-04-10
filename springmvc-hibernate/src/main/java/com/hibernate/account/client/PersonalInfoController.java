package com.hibernate.account.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hibernate.account.bo.PersonalInfoBO;
import com.hibernate.account.vo.PersonalInfoVOO;

@Controller
@SessionAttributes({"firstName","lastName","middleName","gender"})
public class PersonalInfoController {

	@Autowired
	PersonalInfoBO personBO;

	@RequestMapping("/entryAddPersonalDetails.do")
	public String entryAddPersonalDetails(@ModelAttribute PersonalInfoVOO addPersonVOO) {
		System.out.println("AddPersonalInfo Controller : entryAddPersonalDetails() : Start");
		
		System.out.println("AddPersonalInfo Controller : entryAddPersonalDetails() : End");
		return "personalinfo3";
	}

	//Create Personal Details
	@RequestMapping("/processAddPersonalDetails.do")
	public String processAddPersonalDetails(Model model, PersonalInfoVOO addPersonVOO) throws Exception {
		System.out.println("AddPersonalInfo : processAddPersonalDetails() : Start");
		System.out.println("First Name : " + addPersonVOO.getFirstName());
		model.addAttribute("firstName", addPersonVOO.getFirstName());
		model.addAttribute("lastName", addPersonVOO.getLastName());
		model.addAttribute("middleName", addPersonVOO.getMiddleName());
		model.addAttribute("gender", addPersonVOO.getGender());
		try {
			personBO.addPersonalInfo(addPersonVOO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("AddPersonalInfo : processAddPersonalDetails() : End");
		return "contactinfo3";
	}
	
	//Retrieve Personal Details for the given FirstName  
    @RequestMapping(value="/viewPersonalDetails.do")    
    public String processViewPersonalDetails(Model model,PersonalInfoVOO viewPersonVOO){  
    	System.out.println("viewPersonalDetails : processViewPersonalDetails() : Start");
		try {
    	viewPersonVOO = personBO.viewPersonalInfo(viewPersonVOO.getFirstName()); 
    	System.out.println("First Name : " + viewPersonVOO.getFirstName());
        model.addAttribute("viewPersonVOO",viewPersonVOO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("viewPersonalDetails : processViewPersonalDetails() : End");
        return "viewpersonaldetailssuccess";    
    }    
    
    //Update Personal Details for the given FirstName
    @RequestMapping("/modifyPersonalDetails.do")
	public String processModifyPersonalDetails(@ModelAttribute PersonalInfoVOO modifyPersonVOO, Model model) throws Exception {
		System.out.println("ModifyPersonalInfo : processModifyPersonalDetails() : Start");

		System.out.println("entryViewPersonalDetails : Inside : " + modifyPersonVOO.getFirstName()+"  "+modifyPersonVOO.getGender());
		try {
			model.addAttribute("modifyPersonVOO",modifyPersonVOO);
			personBO.modifyPersonalInfo(modifyPersonVOO);
			modifyPersonVOO = personBO.viewPersonalInfo(modifyPersonVOO.getFirstName());
			System.out.println("Inside modify : "+modifyPersonVOO.getGender());			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("ModifyPersonalInfo : processModifyPersonalDetails() : End");
		return "viewpersonaldetailssuccess";
	}
    
    //Delete PersonalDetails on the basis of FirstName
    @RequestMapping("/deletePersonalDetails.do")
   	public String processDeletePersonalDetails(@ModelAttribute PersonalInfoVOO deletePersonVOO) throws Exception {
   		System.out.println("deletePersonalDetails : processDeletePersonalDetails() : Start");

   		System.out.println("deletePersonalDetails : Inside : " + deletePersonVOO.getFirstName());
   		try {
   			personBO.deletePersonalInfo(deletePersonVOO.getFirstName());
   		} catch (Exception e) {
   			e.printStackTrace();
   		}
   		System.out.println("deletePersonalDetails : processDeletePersonalDetails() : End");
   		return "deletesuccess";
   	}	
	
}
