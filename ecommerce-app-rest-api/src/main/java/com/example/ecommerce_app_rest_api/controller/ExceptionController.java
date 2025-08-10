package com.example.ecommerce_app_rest_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.ecommerce_app_rest_api.exception.CustomerNotFoundException;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<String> customerNotFound(CustomerNotFoundException ex){
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

}
