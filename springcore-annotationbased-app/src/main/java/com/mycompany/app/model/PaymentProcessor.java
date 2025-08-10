package com.mycompany.app.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class PaymentProcessor {
	
	@Autowired
	@Qualifier("creditcard")
	private  PaymentService paymentService ;
	
	 public PaymentProcessor() {
		// TODO Auto-generated constructor stub
		super();
	}
	 
	 public void processPayment() {
		 paymentService.makePayment();
	 }
}
