package com.muhammed.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
	
		
		@RequestMapping(path="/register", method=RequestMethod.GET)
		public String showLoginPage() {
			return "register";
		}
		
		
		@RequestMapping(path="/register", method=RequestMethod.POST)
		public String processLogin() {
			
			return "";
		}

}
