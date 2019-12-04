package com.schoolmanagement.Models;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface StudentDao {

	List<Student> getAllStudents();
	
	List<Student> getStudentByClassCodeAndClassGrade(String classCode, int classGrade);
	
	Student getStudentbyName();
	
	List<Student> getStudentsByClassId(int classId);
	
}
