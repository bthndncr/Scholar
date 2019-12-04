package com.schoolmanagement.Models;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
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
		
		
		
		return null;
	}

	@Override
	public List<Student> getStudentByClassCodeAndClassGrade(String classCode, int classGrade) {
		
		List<Student> allStudents = new ArrayList<>();
		
		String sql = "select * from students where class_id = (select class_id from classes where grade_level = ? and class_code = ?)";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, classGrade, classCode );
		
		while(results.next()) {
			Student theStudent = mapToRowStudents(results);
			allStudents.add(theStudent);
		}
		
		return allStudents;
	}


	@Override
	public Student getStudentbyName() {
		// TODO Auto-generated method stub
		return null;
	}

	
	private Student mapToRowStudents(SqlRowSet results) {
		Student theStudent = new Student();
		theStudent.setStudentId(results.getInt("student_id"));
		theStudent.setFirstName(results.getString("first_name"));
		theStudent.setLastName(results.getString("last_name"));
		theStudent.setGender(results.getString("gender"));
		theStudent.setBirthdate(results.getDate("birthday"));
		theStudent.setClassId(results.getInt("class_id"));
		
		return theStudent;
	}

	@Override
	public List<Student> getStudentsByClassId(int classId) {
		List<Student> allStudents = new ArrayList<>();
		
		String sql = "select * from students where class_id = ?;";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, classId);
		
		while(results.next()) {
			Student theStudent = mapToRowStudents(results);
			allStudents.add(theStudent);
		}
		
		return allStudents;
	}
	
	
	
}
