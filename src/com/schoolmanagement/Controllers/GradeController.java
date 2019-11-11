package com.schoolmanagement.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.schoolmanagement.Models.GradeBook.JDBCGradeBookDao;


@Controller
public class GradeController {
	
	@Autowired
	JDBCGradeBookDao gradeDao;
	
	@RequestMapping(path="/dashboard/displayGrades", method=RequestMethod.GET)
	public String showGradeInputPage() {
		
		return "displayGradesForm";
	}
	
	@RequestMapping(path="/dashboard/displayGrades", method=RequestMethod.POST)
	public String processGradeInputs(ModelMap modelHolder, @RequestParam String classCode) {
		
		
		
		return "redirect:/displayGradesForm";
	}
	
//	@RequestMapping(path="/gradeView", method=RequestMethod.GET)
//	public String viewGrades(ModelMap modelMap) {
//		
//		modelMap.put("grades", gradeDao.getAllGrades());
//		return "gradeView";
//	}

}
