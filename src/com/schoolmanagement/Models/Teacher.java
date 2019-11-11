package com.schoolmanagement.Models;

public class Teacher {
	
	private int teacherId;
	private String firstName;
	private String lastName;
	private double phoneNumber;
	private String email;
	private int classId;
	
	public int getTeacherId() {
		return teacherId;
	}
	
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
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
	
	public double getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(double phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getClassId() {
		return classId;
	}
	
	public void setClassId(int classId) {
		this.classId = classId;
	}
}
