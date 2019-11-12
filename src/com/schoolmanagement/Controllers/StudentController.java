package com.schoolmanagement.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/dashboard")
public class StudentController {

	
	@RequestMapping(path="/search", method=RequestMethod.GET)
	public String displayStudentSearch() {
		
		return "studentSearch";
	}
	
	@RequestMapping(path="/search", method=RequestMethod.POST)
	public String processStudentSearch() {
		
		
		return "redirect:/dashboard/search";
	}
	
}
