package com.schoolmanagement.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.schoolmanagement.Models.User;
import com.schoolmanagement.authentication.AuthProvider;

@Controller
public class RegisterController {
	
	@Autowired
    private AuthProvider auth;
		
	@RequestMapping(path="/register", method=RequestMethod.GET)
	public String showLoginPage(ModelMap modelHolder) {
		if (!modelHolder.containsAttribute("user")) {
			modelHolder.addAttribute("user", new User());
		}
		return "register";
	}
	
	
	@RequestMapping(path="/register", method=RequestMethod.POST)
	public String processLogin(
			@Valid @ModelAttribute("user") User user,
			BindingResult result,
			RedirectAttributes flash
			) {
		if (result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + ("user"), result);
			flash.addFlashAttribute("user", user);
			return "redirect:/register";
		}
		
		auth.register(user.getUsername(), user.getPassword(), user.getRole());
		return "redirect:/login";
	}
		
		
		
		
}
