package com.schoolmanagement.Models.GradeBook;

import java.util.List;

public interface GradeDao {
	
	public List<Grade> getAllGrades();
	
	public List<Grade> getGradesByStudentId(int studentId);
	
	public List<Grade> getGradesByAssignmentId(int assignmentId);
	
	public Grade getGradeByStudentAndAssignmentId(int studentId, int assignmentId);
	
	public void insertNewGrade(int assignmentId, int studentId, int pointsPossible, int pointsEarned);

}
