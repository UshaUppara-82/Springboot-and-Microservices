package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Payment;
import com.service.PaymentService;

@RestController
@RequestMapping("/payment")
@CrossOrigin("*")
public class PaymentController {
	@Autowired
	PaymentService paymentService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addPayment(@RequestBody Payment payment){
		return new ResponseEntity<> (paymentService.savePayment(payment), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> viewPayment(@PathVariable long id){
		return new ResponseEntity<> (paymentService.viewPayment(id), HttpStatus.OK);
	}
	@GetMapping("/all")
	public ResponseEntity<?> viewAllPayments(){
		return new ResponseEntity<> (paymentService.viewAllPayments(), HttpStatus.OK);
	}
	
}
