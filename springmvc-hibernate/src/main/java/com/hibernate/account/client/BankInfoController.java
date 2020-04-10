package com.hibernate.account.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hibernate.account.bo.BankInfoBO;
import com.hibernate.account.vo.BankInfoVOO;

@Controller
@SessionAttributes({"bankName","accountNumber","ssn"})
public class BankInfoController {

	@Autowired
	BankInfoBO bankBO;

	@RequestMapping("/entryAddBankDetails.do")
	public String entryAddBankDetails(@ModelAttribute BankInfoVOO addBankVOO) {
		System.out.println("AddBankInfo Controller : entryAddBankDetails() : Start");
		System.out.println("AddBankInfo Controller : entryAddBankDetails() : End");
		return "bankinfo3";
	}

	//Create Bank Details
	@RequestMapping("/processAddBankDetails.do")
	public String processAddBankDetails(Model model, BankInfoVOO addBankVOO) throws Exception {
		System.out.println("AddBankInfo : processAddBankDetails() : Start");
		System.out.println("Bank : " + addBankVOO.getBankName());
		
		model.addAttribute("bankName", addBankVOO.getBankName());
		model.addAttribute("accountNumber", addBankVOO.getAccountNumber());
		model.addAttribute("ssn", addBankVOO.getSsn());
		try {
			bankBO.addBankInfo(addBankVOO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("AddBankInfo : processAddBankDetails() : End");
		return "addaccountsuccess";
	}
	
	//Retrieve bank Details for the given FirstName  
    @RequestMapping(value="/viewbankDetails.do")    
    public String processViewbankDetails(Model model,@ModelAttribute BankInfoVOO viewbankVOO){  
    	System.out.println("viewbankDetails : processViewbankDetails() : Start");
		try {
    	viewbankVOO = bankBO.viewBankInfo(viewbankVOO.getPersonId());
    	System.out.println("First Name : " + viewbankVOO.getPersonId());
        model.addAttribute("viewbankVOO",viewbankVOO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("viewbankDetails : processViewbankDetails() : End");
        return "viewbankdetailssuccess";    
    }    
    
    //Update bank Details for the given FirstName
    @RequestMapping("/modifybankDetails.do")
	public String processbankPersonalDetails(@ModelAttribute BankInfoVOO modifybankVOO, Model model) throws Exception {
		System.out.println("modifybankDetails : processbankPersonalDetails() : Start");

		System.out.println("FirstName : " + modifybankVOO.getPersonId());
		try {
			bankBO.modifyBankInfo(modifybankVOO);
			modifybankVOO = bankBO.viewBankInfo(modifybankVOO.getPersonId());
			model.addAttribute("viewbankVOO",modifybankVOO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("modifybankDetails : processbankPersonalDetails() : End");
		return "viewbankdetailssuccess";
	}
    
    //Delete bankDetails on the basis of FirstName
    @RequestMapping("/deletebankDetails.do")
   	public String processDeletebankDetails(@ModelAttribute BankInfoVOO deletebankVOO) throws Exception {
   		System.out.println("deletebankDetails : processDeletebankDetails() : Start");

   		System.out.println("FirstName : " + deletebankVOO.getPersonId());
   		try {
   			bankBO.deleteBankInfo(deletebankVOO.getPersonId());
   		} catch (Exception e) {
   			e.printStackTrace();
   		}
   		System.out.println("deletebankDetails : processDeletebankDetails() : End");
   		return "deletesuccess";
   	}

}
