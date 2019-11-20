package com.schoolmanagement.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import com.schoolmanagement.authentication.AuthProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class LoginController {
	
	 @Autowired
	 private AuthProvider auth;
	
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}
	
	
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String processLogin(@RequestParam String username, @RequestParam String password, RedirectAttributes flash) {
		
		if(auth.signIn(username, password)) {
			return "redirect:/dashboard";	
		} else {
			flash.addAttribute("message", "Login Invalid");
			return "redirect:/login";
		}
		
	}
	
	@RequestMapping(path="/dashboard", method=RequestMethod.GET)
	public String showDashboard(HttpSession session) {
		if(auth.userHasRole(new String [] {"teacher", "student"})) {
			session.setAttribute("user", auth.getCurrentUser());
			return "dashboard";
		} else {
			return "redirect:/login";
		}
		
	}
	
	@RequestMapping(path = "/logoff", method = RequestMethod.POST)
    public String logOff() {
        auth.logOff();
        return "redirect:/";
    }
	
	
	
	
	

}
