package com.mycompany.app.model;

public class SMSNotification implements NotificationService {
	
	private String mobileNumber;

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public void sendNotification(String message) {
		// TODO Auto-generated method stub
		System.out.println(" Sending SMS to "+mobileNumber+" with "+message);
	}

}
