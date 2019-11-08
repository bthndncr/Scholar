package com.schoolmanagement.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String homePage() {
		return "homePage";
	}
	
	@RequestMapping("/aboutus")
	public String aboutUsPage() {
		return "aboutUs";
	}
	

}
