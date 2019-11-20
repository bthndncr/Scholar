package com.schoolmanagement.Models.Administrators;

import java.time.LocalDate;

public interface AdministratorDao {

	public void createTeacher();
	
	public void createClass();

	void createAnnouncement(int announcementCode, String announcementName, LocalDate dateOfEvent);
	
	
}
