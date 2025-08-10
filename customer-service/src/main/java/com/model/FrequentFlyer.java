package com.model;

import java.time.LocalDate;

import com.util.StatusEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class FrequentFlyer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; //UUID
	
	@ManyToOne
	private Customer customer; //(UUID)
	private String membershipNumber;// (String)

	@Enumerated(EnumType.STRING)
	private StatusEnum status; //(Enum: Silver, Gold, Platinum)
	
	private int pointsEarned;// (Integer)
	private LocalDate tierExpiryDate;// (Date)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getMembershipNumber() {
		return membershipNumber;
	}
	public void setMembershipNumber(String membershipNumber) {
		this.membershipNumber = membershipNumber;
	}
	public StatusEnum getStatus() {
		return status;
	}
	public void setStatus(StatusEnum status) {
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
