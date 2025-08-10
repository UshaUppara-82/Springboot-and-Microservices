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

import com.model.Booking;
import com.service.BookingService;

@RestController
@RequestMapping("/booking")
@CrossOrigin(origins = "http://localhost:4200")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addBooking(@RequestBody Booking booking){
		System.out.println("$$$$$$$$$$$$$$$$$ "+booking);
		System.out.println("$$$$$$$$$$$$$$$$$ "+booking.getPayment());
		return new ResponseEntity<> (bookingService.saveBooking(booking), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> viewBooking(@PathVariable long id){
		return new ResponseEntity<> (bookingService.viewBooking(id), HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> viewAllBooking(){
		return new ResponseEntity<> (bookingService.viewAllBooking(), HttpStatus.OK);
	}
	
	@GetMapping("/details/{id}")
	public ResponseEntity<?> getFullBooking(@PathVariable long id){
		return new ResponseEntity<> (bookingService.viewDetails(id), HttpStatus.OK);
	}

}
