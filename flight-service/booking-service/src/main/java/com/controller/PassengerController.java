package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Passenger;
import com.service.PassengerService;

@RestController
@RequestMapping("/passenger")
public class PassengerController {
	@Autowired
	PassengerService passengerService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addPassenger(@RequestBody Passenger passenger){
		return new ResponseEntity<> (passengerService.savePassenger(passenger), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> viewPassenger(@PathVariable long id){
		return new ResponseEntity<> (passengerService.viewPassenger(id), HttpStatus.OK);
	}

}
