package com.schoolmanagement.Models.Administrators;

import java.time.LocalDate;

public class Announcement {
	
	private int announcementId;
	private String announcementName;
	private int announcementCode;
	private LocalDate dateAnnouncementMade;
	private LocalDate dateOfEvent;
	private int administratorId;
	
	public int getAnnouncementId() {
		return announcementId;
	}
	
	public void setAnnouncementId(int announcementId) {
		this.announcementId = announcementId;
	}
	
	public String getAnnouncementName() {
		return announcementName;
	}
	
	public void setAnnouncementName(String announcementName) {
		this.announcementName = announcementName;
	}
	
	public int getAnnouncementCode() {
		return announcementCode;
	}
	
	public void setAnnouncementCode(int announcementCode) {
		this.announcementCode = announcementCode;
	}
	
	public LocalDate getDateAnnouncementMade() {
		return dateAnnouncementMade;
	}
	
	public void setDateAnnouncementMade(LocalDate dateAnnouncementMade) {
		this.dateAnnouncementMade = dateAnnouncementMade;
	}
	
	public LocalDate getDateOfEvent() {
		return dateOfEvent;
	}
	
	public void setDateOfEvent(LocalDate dateOfEvent) {
		this.dateOfEvent = dateOfEvent;
	}
	
	public int getAdministratorId() {
		return administratorId;
	}
	
	public void setAdministratorId(int administratorId) {
		this.administratorId = administratorId;
	}

}
