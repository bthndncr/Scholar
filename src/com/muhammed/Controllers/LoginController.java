package com.muhammed.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}
	
	
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String processLogin() {
		
		return "redirect:/dashboard";
	}
	
	@RequestMapping(path="/dashboard", method=RequestMethod.GET)
	public String showDashboard() {
		
		return "dashboard";
	}
	
	
	

}
