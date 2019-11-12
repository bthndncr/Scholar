package com.schoolmanagement.Models;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JDBCStudentDao implements StudentDao {
	
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCStudentDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getStudentByClassCodeAndClassGrade(int classCode, String classGrade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getStudentbyName() {
		// TODO Auto-generated method stub
		return null;
	}

}
