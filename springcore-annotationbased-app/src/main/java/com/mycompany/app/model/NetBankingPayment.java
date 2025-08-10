package com.mycompany.app.model;

import org.springframework.stereotype.Component;

@Component("netbanking")
public class NetBankingPayment implements PaymentService {

	@Override
	public void makePayment() {
		// TODO Auto-generated method stub
		System.out.println("Payment made using net banking");
	}

}
