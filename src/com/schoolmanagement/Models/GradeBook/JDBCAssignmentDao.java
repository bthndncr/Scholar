package com.schoolmanagement.Models.GradeBook;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCAssignmentDao implements AssignmentDao {
	
	JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCAssignmentDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Assignment> getAssignmentsByClassId(int classId) {
		List<Assignment> listOfAssignments = new ArrayList<Assignment>();
		String sqlGetAssignByClassID = "SELECT * FROM assignments WHERE class_id = ? ;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAssignByClassID, classId);
		while (results.next()) {
			Assignment newAssign = mapToRowAssignment(results);
			listOfAssignments.add(newAssign);
		}
		return listOfAssignments;
	}

	@Override
	public List<TheClass> getAllClasses() {
		List<TheClass> listOfClasses  = new ArrayList<TheClass>();
		String sqlGetAllClasses = "Select * from classes;" ;
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllClasses);
		while (results.next()) {
			TheClass newClass = mapRowToClass(results);
			listOfClasses.add(newClass);
		}
		return listOfClasses;
	}
	
	private Assignment mapToRowAssignment(SqlRowSet results) {
		Assignment theAssignment = new Assignment();
		theAssignment.setAssignmentId(results.getInt("assignment_id"));
		theAssignment.setClassId(results.getInt("class_id"));
		theAssignment.setPointsPossible(results.getInt("points_possible"));
		theAssignment.setDateAssigned(results.getDate("date_assigned"));
		theAssignment.setDueDate(results.getDate("date_due"));
		theAssignment.setTitle(results.getString("title"));
		return theAssignment;
		
	}
	
	
	private TheClass mapRowToClass(SqlRowSet results) {
		TheClass theClass = new TheClass();
		theClass.setClassId(results.getInt("class_id"));
		theClass.setClassCode(results.getString("class_code"));
		theClass.setRoomCode(results.getInt("room_code"));
		theClass.setGradeLevel(results.getInt("grade_level"));
		return theClass;
		
	}

}
