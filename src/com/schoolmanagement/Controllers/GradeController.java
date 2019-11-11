package com.schoolmanagement.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.schoolmanagement.Models.Grades.JDBCGradeDao;


@Controller
public class GradeController {
	
	@Autowired
	JDBCGradeDao gradeDao;
	
	@RequestMapping(path="/gradeInput", method=RequestMethod.GET)
	public String showGradeInputPage(@RequestParam int assignmentId, ModelMap modelMap) {
		
		
		return "gradeInput";
	}
	
	@RequestMapping(path="/gradeInput", method=RequestMethod.POST)
	public String processGradeInputs() {
		return "redirect:/gradeView";
	}
	
	@RequestMapping(path="/gradeView", method=RequestMethod.GET)
	public String viewGrades(ModelMap modelMap) {
		
		modelMap.put("grades", gradeDao.getAllGrades());
		return "gradeView";
	}

}
