package com.schoolmanagement.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.schoolmanagement.Models.Grades.JDBCGradeDao;


@Controller
public class GradeController {
	
	@Autowired
	JDBCGradeDao gradeDao;
	
	@RequestMapping(path="/gradeInput", method=RequestMethod.GET)
	public String showGradeInputPage() {
		return "gradeInput";
	}
	
	@RequestMapping(path="/gradeInput", method=RequestMethod.POST)
	public String processGradeInputs() {
		return "redirect:/gradeView";
	}
	
	@RequestMapping(path="/gradeView", method=RequestMethod.GET)
	public String viewGrades() {
		return "gradeView";
	}

}
