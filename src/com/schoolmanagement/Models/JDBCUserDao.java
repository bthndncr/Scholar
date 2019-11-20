package com.schoolmanagement.Models;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
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
		byte[] salt = passwordHasher.generateRandomSalt();
        String hashedPassword = passwordHasher.computeHash(password, salt);
        String saltString = new String(Base64.encode(salt));
        long newId = jdbcTemplate.queryForObject(
                "INSERT INTO registrations(username, password, salt, role_title) VALUES (?, ?, ?, ?) RETURNING id", Long.class,
                userName, hashedPassword, saltString, role);

        User newUser = new User();
        newUser.setId(newId);
        newUser.setUsername(userName);
        newUser.setRole(role);

        return newUser;
	}

	@Override
	public User getValidUserWithPassword(String userName, String password, String role) {
		 String sqlSearchForUser = "SELECT * FROM registrations WHERE UPPER(username) = ? and role_title = ?";

	        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchForUser, userName.toUpperCase(), role);
	        if (results.next()) {
	            String storedSalt = results.getString("salt");
	            String storedPassword = results.getString("password");
	            String hashedPassword = passwordHasher.computeHash(password, Base64.decode(storedSalt));
	            if (storedPassword.equals(hashedPassword)) {
	                return mapResultToUser(results);
	            } else {
	                return null;
	            }
	        } else {
	            return null;
	        }
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
        String sqlSelectAllUsers = "SELECT id, username, role_title FROM registrations";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllUsers);

        while (results.next()) {
            User user = mapResultToUser(results);
            users.add(user);
        }

        return users;
	}

	
	
	private User mapResultToUser(SqlRowSet results) {
        User user = new User();
        user.setId(results.getLong("id"));
        user.setUsername(results.getString("username"));
        user.setRole(results.getString("role_title"));
        return user;
    }
}
