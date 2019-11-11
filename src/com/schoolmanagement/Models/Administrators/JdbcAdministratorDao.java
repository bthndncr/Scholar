package com.schoolmanagement.Models.Administrators;

import java.time.LocalDate;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class JdbcAdministratorDao implements AdministratorDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcAdministratorDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void createAnnouncement(@RequestParam int announcementCode, @RequestParam String announcementName, @RequestParam LocalDate dateOfEvent) {
		LocalDate dateAnnouncementMade = LocalDate.now();
		Announcement newAnnouncement = new Announcement();
		newAnnouncement.setAnnouncementCode(announcementCode);
		newAnnouncement.setAnnouncementName(announcementName);
		newAnnouncement.setDateAnnouncementMade(dateAnnouncementMade);
		newAnnouncement.setDateOfEvent(dateOfEvent);
		String sqlCreateAnnouncement = "INSERT INTO announcements(announcement_code, announcement_name, date_announcement_made, date_of_event) "
									 + "VALUES (?, ?, ?, ?);";
		
		jdbcTemplate.update(sqlCreateAnnouncement, newAnnouncement.getAnnouncementCode(),
												   newAnnouncement.getAnnouncementName(),
												   newAnnouncement.getDateAnnouncementMade(),
												   newAnnouncement.getDateOfEvent());
		
	}

	@Override
	public void createTeacher() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createClass() {
		// TODO Auto-generated method stub
		
	}

	
}
