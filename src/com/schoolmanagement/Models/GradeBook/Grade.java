package com.schoolmanagement.Models.GradeBook;

public class Grade {
	
	private int pointsPossible;
	private double pointsEarned;
	private int assignmentId;
	private int studentId;
	private String firstName;
	private String lastName;
	private String assignmentTitle;
	
	public int getPointsPossible() {
		return pointsPossible;
	}
	public void setPointsPossible(int pointsPossible) {
		this.pointsPossible = pointsPossible;
	}
	public double getPointsEarned() {
		return pointsEarned;
	}
	public void setPointsEarned(double pointsEarned) {
		this.pointsEarned = pointsEarned;
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAssignmentTitle() {
		return assignmentTitle;
	}
	public void setAssignmentTitle(String assignmentTitle) {
		this.assignmentTitle = assignmentTitle;
	}
	
	
	
	

}
