package com.schoolmanagement.Models;

import java.util.List;


public interface UserDao {

	public User saveUser(String userName, String password, String role);
	
	public User getValidUserWithPassword(String userName, String password, String role);
	
	public List<User> getAllUsers();
}
