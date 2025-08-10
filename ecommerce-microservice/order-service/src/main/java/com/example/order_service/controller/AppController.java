package com.example.order_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.order_service.model.Order;
import com.example.order_service.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class AppController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping
    public ResponseEntity<Order> createOrder(@RequestParam Long customerId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(customerId));
    }

	
	@PostMapping("/place/{customerId}")
	public String placeOrder(@PathVariable Long customerId) {
		return orderService.placeOrder(customerId);
		
	}
	
	@GetMapping("/{productId}/qty/{quantity}")
	public Order createOrderWithProduct(@PathVariable Long productId, @PathVariable Integer quantity) {
		return orderService.createOrderWithProduct(productId, quantity);
	}
}
