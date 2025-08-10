package com.dto;

import java.time.LocalDate;

public class FrequentFlyerDTO {
	
	private long id; 
	private CustomerDTO customer; //(UUID)
	private String membershipNumber;// (String)

	private String status; //(Enum: Silver, Gold, Platinum)
	
	private int pointsEarned;// (Integer)
	private LocalDate tierExpiryDate;// (Date)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public CustomerDTO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
	public String getMembershipNumber() {
		return membershipNumber;
	}
	public void setMembershipNumber(String membershipNumber) {
		this.membershipNumber = membershipNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getPointsEarned() {
		return pointsEarned;
	}
	public void setPointsEarned(int pointsEarned) {
		this.pointsEarned = pointsEarned;
	}
	public LocalDate getTierExpiryDate() {
		return tierExpiryDate;
	}
	public void setTierExpiryDate(LocalDate tierExpiryDate) {
		this.tierExpiryDate = tierExpiryDate;
	}
	

}
