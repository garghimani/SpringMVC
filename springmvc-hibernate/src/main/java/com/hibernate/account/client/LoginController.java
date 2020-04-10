package com.hibernate.account.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hibernate.account.bo.AccountBO;
import com.hibernate.account.vo.AccountVOO;

@Controller
public class LoginController {

	@Autowired
	AccountBO accBO;

	@RequestMapping("/entryAddLogin.do")
	public String entryAddLogin(@ModelAttribute AccountVOO accVO) {
		System.out.println("Login Controller : entryAddLogin() : Start");
		System.out.println("Login Controller : entryAddLogin() : End");
		return "login";
	}

	@RequestMapping("/processAddLogin.do")
	public String processAddLogin(@ModelAttribute AccountVOO accVO) throws Exception {
		System.out.println("LoginController : processAddLogin() : Start");
		System.out.println("First Name and Password: " + accVO.getUserName()+" "+accVO.getPasswd());
		try {
			accBO.addLoginDetails(accVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("LoginController : processAddLogin() : End");
		return "home";
	}

}
