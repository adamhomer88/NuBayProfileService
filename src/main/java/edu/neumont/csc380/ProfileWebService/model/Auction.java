package edu.neumont.csc380.ProfileWebService.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "auction")
public class Auction {
	public enum Status{
		READY, WAIT, COMPLETE
	}
	private int id;
	private String name;
	private String description;
	private double highestBid;
	private ProfileInformation highestBidOwner;
	private Date startDate;
	private Date endDate;
	private ProfileInformation owner;
	private Status status;
	private String thumbnail;
	private String image;
	private String placeBid;
	private String edit;
	private String delete;
	private String history;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getHighestBid() {
		return highestBid;
	}
	public void setHighestBid(double highestBid) {
		this.highestBid = highestBid;
	}
	public ProfileInformation getHighestBidOwner() {
		return highestBidOwner;
	}
	public void setHighestBidOwner(ProfileInformation highestBidOwner) {
		this.highestBidOwner = highestBidOwner;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public ProfileInformation getOwner() {
		return owner;
	}
	public void setOwner(ProfileInformation owner) {
		this.owner = owner;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPlaceBid() {
		return placeBid;
	}
	public void setPlaceBid(String placeBid) {
		this.placeBid = placeBid;
	}
	public String getEdit() {
		return edit;
	}
	public void setEdit(String edit) {
		this.edit = edit;
	}
	public String getDelete() {
		return delete;
	}
	public void setDelete(String delete) {
		this.delete = delete;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
}
