package com.mycompany.app.model;

public class EmailNotification implements NotificationService {
	
	private String emailAddress;
	

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public void sendNotification(String message) {
		// TODO Auto-generated method stub
		System.out.println(" Sending Email to "+emailAddress+ " with "+message);
	}
	

}
