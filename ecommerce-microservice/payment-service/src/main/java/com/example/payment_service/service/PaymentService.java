package com.example.payment_service.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payment_service.model.Payment;
import com.example.payment_service.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
    private PaymentRepository paymentRepository;
    
    
    public Payment createPayment(Long orderId, Double amount) {
		/*
		 * Optional<Order> order = orderRepository.findById(orderId); if
		 * (!order.isPresent()) { throw new RuntimeException("Order not found"); }
		 */
        Payment payment = new Payment();
       // payment.setOrder(1L);
        payment.setAmount(amount);
        payment.setStatus("Completed");
        payment.setPaymentDate(LocalDateTime.now());

        return paymentRepository.save(payment);
    }


	public List<Payment> getAllPayments() {
		
		return paymentRepository.findAll();
		// TODO Auto-generated method stub
		//return null;
	}


	public Payment getPaymentById(String id) {
		// TODO Auto-generated method stub
		return paymentRepository.findById(id).get();
	}

}
