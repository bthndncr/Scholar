package com.schoolmanagement.Models.GradeBook;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.schoolmanagement.Models.Student;

@Component
public class JDBCGradeBookDao implements GradeDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCGradeBookDao(DataSource dataSource) {
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
		String sqlGetGradesByAssignment = "SELECT  students.first_name, students.last_name, assignments.title, grades.points_earned FROM grades " + 
				"JOIN students " + 
				"ON students.student_id = grades.student_id " + 
				"Join assignments " + 
				"on assignments.assignment_id = grades.assignment_id " + 
				"WHERE grades.student_id in (SELECT student_id from students where class_id = (SELECT class_id from classes where grade_level = ? and class_code = ? ));";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetGradesByAssignment, assignmentId);
		while (results.next()) {
			Grade newGrade = mapRowToGrade(results);
			gradesByAssignment.add(newGrade);
		}
		return gradesByAssignment;
	}
	
	@Override
	public List<Grade> getGradesForAClass(int grade, String code, String sort) {
		List<Grade> classGrades = new ArrayList<Grade>();
		String sqlGetGradesByAssignment = "SELECT students.first_name as first_name, students.last_name as last_name, assignments.title as title, grades.points_earned as points_earned FROM grades " + 
				"JOIN students " + 
				"ON students.student_id = grades.student_id " + 
				"Join assignments " + 
				"on assignments.assignment_id = grades.assignment_id " + 
				"WHERE grades.student_id in (SELECT student_id from students where class_id = (SELECT class_id from classes where grade_level = ? and class_code = ? ))"
				+ "	ORDER BY " + sort + " desc";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetGradesByAssignment, grade, code );
		while (results.next()) {
			Grade newGrade = mapRowToGrade(results);
			classGrades.add(newGrade);
		}
		return classGrades;
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
	
	public List<Student> getStudents() {
		List<Student> studentListForGrades = new ArrayList<Student>();
		
		return studentListForGrades;
	}
	
	
	public List<Assignment> getAssignmentsByClassId(int classId){
		List<Assignment> allAssignments = new ArrayList<>();
		
		String sql = "select * from assignments "
					+ "WHERE class_id in (select class_id from classes where class_code = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, classId );
		while(results.next()) {
			Assignment theAssignment = mapToRowAssignment(results);
			allAssignments.add(theAssignment);
		}
		return allAssignments;
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
	
	private Grade mapRowToGrade(SqlRowSet results) {
		Grade newGrade = new Grade();
		newGrade.setFirstName(results.getString("first_name"));
		newGrade.setLastName(results.getString("last_name"));
		newGrade.setAssignmentTitle(results.getString("title"));
		newGrade.setPointsEarned(results.getDouble("points_earned"));
		
		return newGrade;
	}
	
	

}
