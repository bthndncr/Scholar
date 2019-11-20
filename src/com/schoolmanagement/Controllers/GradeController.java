package com.schoolmanagement.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.schoolmanagement.Models.GradeBook.GradeDao;
import com.schoolmanagement.Models.GradeBook.JDBCGradeBookDao;


@Controller
public class GradeController {
	
	@Autowired
	GradeDao gradeDao;
	
	@RequestMapping(path="/displayGrades", method=RequestMethod.GET)
	public String showGradeInputPage() {
		
		return "displayGradesForm";
	}
	
	@RequestMapping(path="/displayGrades", method=RequestMethod.POST)
	public String processGradeInputs(@RequestParam int grade, @RequestParam String code, @RequestParam String sort, HttpSession session) {
		
		/// pull the assignments by classCode
		
		session.setAttribute("grades", gradeDao.getGradesForAClass(grade, code, sort));
		session.setAttribute("classGrade", grade);
		session.setAttribute("classCode", code);
		
		return "redirect:/displayGrades";
	}
	

}
