package com.mycompany.app.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Message {
	
	@Value(value="101")
	private Integer messageId;
	
	@Value(value="Welcome to Spring Framework!")
	private String message;
	
	
	@Value("#{'${user.names:SriKanth,Anil}'.split(',')}")
 private List<String> appUsers;
	 

	  
	  public void printUsers() {
		  appUsers.forEach(System.out::println);
	    }
	  
	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", message=" + message + "]";
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
