package com.dto;

import java.time.LocalDate;

public class NotificationDTO {
	
	private long notificationId;
	private CustomerDTO customer;// (UUID)
	private String message;//(String)
	private String type;// (Enum: Email, SMS, Push)
	private String sentStatus;// (Enum: Pending, Sent, Failed)
	private LocalDate sentDate; //(DateTime)
	
	public long getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(long notificationId) {
		this.notificationId = notificationId;
	}
	public CustomerDTO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSentStatus() {
		return sentStatus;
	}
	public void setSentStatus(String sentStatus) {
		this.sentStatus = sentStatus;
	}
	public LocalDate getSentDate() {
		return sentDate;
	}
	public void setSentDate(LocalDate sentDate) {
		this.sentDate = sentDate;
	}
	
	

}
