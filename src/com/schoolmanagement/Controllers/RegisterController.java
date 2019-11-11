package com.schoolmanagement.Controllers;

import javax.servlet.Registration;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegisterController {
	
		
		@RequestMapping(path="/register", method=RequestMethod.GET)
		public String showLoginPage(ModelMap modelHolder) {
			if (!modelHolder.containsAttribute("Registration")) {
				modelHolder.addAttribute("Registration", new Registration());
			}
			return "register";
		}
		
		
		@RequestMapping(path="/register", method=RequestMethod.POST)
		public String processLogin(
				@Valid @ModelAttribute("Registration") Registration newRegistration,
				BindingResult result,
				RedirectAttributes flash
				) {
			if (result.hasErrors()) {
				flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + ("Registration"), result);
				flash.addFlashAttribute("Registration", newRegistration);
				return "redirect:/register";
			}
			
			
			return "redirect:/registerConfirmation";
		}
		
		@RequestMapping(path="/registerConfirmation", method=RequestMethod.GET)
		public String showConfirmationPage() {
			return "registerConfirmation";
		}
		
		
}
