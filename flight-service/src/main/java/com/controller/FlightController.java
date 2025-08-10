package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.model.*;
import com.service.*;



@RestController
@RequestMapping("/flight")
public class FlightController {
	
	@Autowired
	FlightService lightService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addFlight(@RequestBody Flight light){
		return new ResponseEntity<> (lightService.saveFlight(light), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> viewFlight(@PathVariable long id){
		return new ResponseEntity<> (lightService.viewFlight(id), HttpStatus.OK);
	}
	
}
