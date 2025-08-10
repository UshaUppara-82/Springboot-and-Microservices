package com.example.payment_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.payment_service.model.Payment;
import com.example.payment_service.service.PaymentService;


@RestController
@RequestMapping("/api/payments")
public class AppController {
	
	@Autowired
	PaymentService paymentService;
	
	@PostMapping
    public ResponseEntity<Payment> createPayment(@RequestParam Double amount) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.createPayment(1L, amount));
    }

	@GetMapping
	public List<Payment> getAllPayments(){
		return paymentService.getAllPayments();
		
	}
	@GetMapping("/{id}")
	public Payment getPaymentById(@PathVariable String id){
		return paymentService.getPaymentById(id);
		
	}
}
