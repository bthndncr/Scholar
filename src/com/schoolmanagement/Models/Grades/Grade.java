package com.schoolmanagement.Models.Grades;

public class Grade {
	
	private int pointsPossible;
	private int pointsAllowed;
	private int assignmentId;
	private int studentId;
	
	public int getPointsPossible() {
		return pointsPossible;
	}
	public void setPointsPossible(int pointsPossible) {
		this.pointsPossible = pointsPossible;
	}
	public int getPointsAllowed() {
		return pointsAllowed;
	}
	public void setPointsAllowed(int pointsAllowed) {
		this.pointsAllowed = pointsAllowed;
	}
	public int getAssignmentId() {
		return assignmentId;
	}
	public void setAssignmentId(int assignmentId) {
		this.assignmentId = assignmentId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	

}
