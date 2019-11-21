package com.schoolmanagement.Models.GradeBook;

import java.util.List;

public interface AssignmentDao {
	
	List<Assignment> getAssignmentsByClassId(int classId);
	
	List<TheClass> getAllClasses();

}
