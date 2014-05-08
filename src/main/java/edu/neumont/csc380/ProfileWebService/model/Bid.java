package edu.neumont.csc380.ProfileWebService.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "bid")
public class Bid {

	private double amount;
	private ProfileInformation owner;
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public ProfileInformation getOwner() {
		return owner;
	}
	public void setOwner(ProfileInformation owner) {
		this.owner = owner;
	}
	
}
