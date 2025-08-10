package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.ResourceNotFoundException;
import com.model.Booking;
import com.model.Payment;
import com.repository.PaymentRepository;

@Service
public class PaymentService {
	@Autowired
	PaymentRepository paymentRepository;
	
	public Payment savePayment(Payment payment) {
		return paymentRepository.save(payment);
	}
	
	public Payment viewPayment(long id) {
		Payment exist = paymentRepository.findById(id).orElse(null);
		if (exist==null) {
			throw new ResourceNotFoundException("Particular Resource is not found");
		}
		return exist;
	}
public List<Payment> viewAllPayments() {
		
		return paymentRepository.findAll();
	}

}
