package com.mycompany.app.model;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component("creditcard")
public class CreditCardPayment implements PaymentService{

	@Override
	public void makePayment() {
		// TODO Auto-generated method stub
		System.out.println("Payment made thro credit card");
	}
	
	
	@PostConstruct
	public void init() {
		
		System.out.println(" Initialising the creditcard ....");
		//steps for db initialization
		System.out.println(" the creditcard initialized successfully!");
	}
	
	@PostConstruct
	public void setupVISA() {
		
		System.out.println(" Initialising the creditcard - VISA ....");
		//steps for db initialization
		System.out.println(" the creditcard - VISA initialized successfully!");
	}

	
	@PostConstruct
	public void setupMasterCard() {
		
		System.out.println(" Initialising the creditcard - MasterCard ....");
		//steps for db initialization
		System.out.println(" the creditcard - MasterCard initialized successfully!");
	}

}
