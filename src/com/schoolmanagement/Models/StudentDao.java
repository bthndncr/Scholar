package com.schoolmanagement.Models;

import java.util.List;

public interface StudentDao {

	List<Student> getAllStudents();
	
	List<Student> getStudentByClassCodeAndClassGrade(String classCode, int classGrade);
	
	Student getStudentbyName();
	
}
