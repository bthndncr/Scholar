package com.schoolmanagement.authentication;

import com.schoolmanagement.Models.User;

public interface AuthProvider {

	boolean isLoggedIn();
	
	User getCurrentUser();
	
	boolean signIn(String username, String password);
	
	void logOff();
	
	void register(String username, String password, String role);
	
	boolean userHasRole(String[] roles);
	
}
