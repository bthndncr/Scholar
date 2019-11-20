package com.schoolmanagement.Controllers;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.schoolmanagement.Models.JDBCStudentDao;
import com.schoolmanagement.Models.StudentDao;

@Controller
public class StudentController {
	
	@Autowired
	StudentDao studentDao;

	
	@RequestMapping(path="/search", method=RequestMethod.GET)
	public String displayStudentSearch() {
		return "studentSearch";
	}
	
	@RequestMapping(path="/searchInput", method=RequestMethod.GET)
	public String processStudentSearch(@RequestParam int grade, @RequestParam String code,  ModelMap modelMap) {
		
		modelMap.put("students", studentDao.getStudentByClassCodeAndClassGrade(code, grade));
		
		
		return "studentSearch";
	}
	
}
