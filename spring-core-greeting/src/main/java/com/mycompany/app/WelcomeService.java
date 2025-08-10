package com.mycompany.app;

//Spring Bean
public class WelcomeService {
	
	private String message;
	
	public void setMessage(String message) {
		this.message = message;
	}

	public String welcome() {
		return "Welcome to Spring Frameworks!";
	}

	
	public void sayWelcomeWithMessage() {
		System.out.println("We are learning "+message);
	}
}
