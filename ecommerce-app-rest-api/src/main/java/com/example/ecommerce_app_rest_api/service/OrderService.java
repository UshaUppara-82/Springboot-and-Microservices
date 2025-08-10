package com.example.ecommerce_app_rest_api.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce_app_rest_api.exception.CustomerNotFoundException;
import com.example.ecommerce_app_rest_api.model.*;
import com.example.ecommerce_app_rest_api.repository.OrderRepository;

@Service

public class OrderService {
	@Autowired
    private CustomerService customerService;
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductService productService;

	 public Order createOrder(Long customerId) throws CustomerNotFoundException {
	        Customer customer = customerService.getCustomerById(customerId);
	        if (customer == null) {
	            throw new RuntimeException("Customer not found");
	        }
	        
	     
	        
	        Order order = new Order();
	        order.setOrderDate(LocalDateTime.now());
	        order.setCustomer(customer);
	        
	        
	        return orderRepository.save(order);
	    }
	 
	 public Order createOrderWithProducts(Long customerId, List<Long> productIds) {
	        Customer customer = customerService.getCustomerByEmail("vikas@hotmail.com");
	        if (customer == null) {
	            throw new RuntimeException("Customer not found");
	        }
	        Order order = new Order();
	        
	        List<Product> products = productIds.stream()
	                .map(productId ->{
	                	Product p = productService.getProductById(productId).get();
	                	//relation set -> fill your join table
	                	order.addProduct(p);
	                	return p;
	                })
	                .collect(Collectors.toList());
	        
	        
	        order.setCustomer(customer);
	      //relation set -> fill your join table
	        order.setProducts(products);
	        order.setOrderDate(LocalDateTime.now());

	        return orderRepository.save(order);
	    }
	}

