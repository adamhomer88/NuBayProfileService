package edu.neumont.csc380.ProfileWebService.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "profileInformation")
public class ProfileInformation {
	
	private int id;
	private String details;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
}
