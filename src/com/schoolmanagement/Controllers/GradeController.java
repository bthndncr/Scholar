package com.schoolmanagement.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.schoolmanagement.Models.StudentDao;
import com.schoolmanagement.Models.GradeBook.AssignmentDao;
import com.schoolmanagement.Models.GradeBook.GradeDao;


@Controller
public class GradeController {
	
	@Autowired
	GradeDao gradeDao;
	
	@Autowired
	AssignmentDao assignmentDao;
	
	@Autowired
	StudentDao studentDao;
	
	@RequestMapping(path="/displayGrades", method=RequestMethod.GET)
	public String showGradeInputPage() {
		
		return "displayGradesForm";
	}
	
	@RequestMapping(path="/displayGrades", method=RequestMethod.POST)
	public String processGradeInputs(@RequestParam int grade, @RequestParam String code, @RequestParam String sort, HttpSession session) {
		
		
		session.setAttribute("grades", gradeDao.getGradesForAClass(grade, code, sort));
		session.setAttribute("classGrade", grade);
		session.setAttribute("classCode", code);
		
		return "redirect:/displayGrades";
	}
	
	
	@RequestMapping(path="/inputGrades", method=RequestMethod.GET)
	public String displayInputGradesForm(ModelMap map) {
		map.addAttribute("classes", assignmentDao.getAllClasses());

		
		return "displayInputGradesForm";
	}
	
	
	@RequestMapping(path="/inputGrades", method=RequestMethod.POST)
	public String processSelectingClass(HttpSession session, ModelMap map, @RequestParam int classId) {
		
		session.setAttribute("assignments", assignmentDao.getAssignmentsByClassId(classId));
		map.addAttribute("students", studentDao.getStudentsByClassId(classId));
		
		return "redirect:/inputGrades";
	}

	@RequestMapping(path="/assignmentsomething", method=RequestMethod.GET)
	public String displayNewAssignmentForm(ModelMap map) {
		map.addAttribute("classes", assignmentDao.getAllClasses());
		return "displayAssignmentForm";
	}
	
	//@RequestMapping(path="/assignmentsomething", method=RequestMethod.POST)
	//public String processAssignmentCreation(ModelAttribute("Assignment") Assignment assigment,)

}
