package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.model.*;
import com.service.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
		return new ResponseEntity<> (customerService.saveCustomer(customer), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> viewCustomer(@PathVariable long id){
		return new ResponseEntity<> (customerService.viewCustomer(id), HttpStatus.OK);
	}
	
}
