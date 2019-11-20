package com.schoolmanagement.Models;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.schoolmanagement.authentication.PasswordHasher;


@Component
public class JDBCUserDao implements UserDao {
	
	 private JdbcTemplate jdbcTemplate;
	 private PasswordHasher passwordHasher;
	
	 @Autowired
	 public JDBCUserDao(DataSource dataSource, PasswordHasher passwordHasher) {
	 this.jdbcTemplate = new JdbcTemplate(dataSource);
	 this.passwordHasher = passwordHasher;
	 }
	

	@Override
	public User saveUser(String userName, String password, String role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getValidUserWithPassword(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
