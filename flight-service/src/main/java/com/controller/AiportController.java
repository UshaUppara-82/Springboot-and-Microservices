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

import com.model.Airport;
import com.service.AirportService;

@RestController
@RequestMapping("/airport")
public class AiportController {
	@Autowired
	AirportService airportService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addAirport(@RequestBody Airport airport){
		return new ResponseEntity<> (airportService.saveAirport(airport), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> viewAirport(@PathVariable long id){
		return new ResponseEntity<> (airportService.viewAirport(id), HttpStatus.OK);
	}

}
