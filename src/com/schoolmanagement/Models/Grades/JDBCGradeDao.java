package com.schoolmanagement.Models.Grades;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCGradeDao implements GradeDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCGradeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Grade> getAllGrades() {
		List<Grade> allGrades = new ArrayList<Grade>();
		String sqlGetAllGrades = "SELECT * FROM grades ;";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllGrades);
		
		while (results.next()) {
			Grade newGrade = mapRowToGrade(results);
			allGrades.add(newGrade);
		}
		return allGrades;
	}

	@Override
	public List<Grade> getGradesByStudentId(int studentId) {
		List<Grade> gradesByStudent = new ArrayList<Grade>();
		String sqlGetGradesByStudent = "SELECT * FROM grade "
										+ "WHERE student_id = ? ;";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetGradesByStudent, studentId);
		while (results.next()) {
			Grade newGrade = mapRowToGrade(results);
			gradesByStudent.add(newGrade);
		}
		return gradesByStudent;
	}

	@Override
	public List<Grade> getGradesByAssignmentId(int assignmentId) {
		List<Grade> gradesByAssignment = new ArrayList<Grade>();
		String sqlGetGradesByAssignment = "SELECT * FROM grade "
										+ "WHERE assignment_id = ? ;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetGradesByAssignment, assignmentId);
		while (results.next()) {
			Grade newGrade = mapRowToGrade(results);
			gradesByAssignment.add(newGrade);
		}
		return gradesByAssignment;
	}

	@Override
	public Grade getGradeByStudentAndAssignmentId(int studentId, int assignmentId) {
		
		String sqlGradeByStudentAndAssign = "SELECT * FROM grade "
										  + "WHERE student_id = ? AND assignment_id = ? ; ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGradeByStudentAndAssign, studentId, assignmentId);
		Grade gradeByStudentAndAssignment = mapRowToGrade(results);
		return gradeByStudentAndAssignment;
	}
	
	@Override
	public void insertNewGrade(int assignmentId, int studentId, int pointsPossible, int pointsEarned) {
		String sqlInsertNewGrade = "INSERT INTO grade (assignment_id, student_id, points_possible, points_earned) "
								 + "VALUES (? , ? , ? , ?) ;";
		jdbcTemplate.queryForRowSet(sqlInsertNewGrade, assignmentId, studentId, pointsPossible, pointsEarned);
	}

	private Grade mapRowToGrade(SqlRowSet results) {
		Grade newGrade = new Grade();
		newGrade.setAssignmentId(results.getInt("assignment_id"));
		newGrade.setPointsAllowed(results.getInt("points_allowed"));
		newGrade.setPointsPossible(results.getInt("points_possible"));
		newGrade.setStudentId(results.getInt("student_id"));
		return newGrade;
	}
	
	

}
