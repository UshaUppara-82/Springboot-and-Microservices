package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.ResourceNotFoundException;
import com.model.Passenger;
import com.repository.PassengerRepository;

@Service
public class PassengerService {
	@Autowired
	PassengerRepository passengerRepository;
	
	public Passenger savePassenger(Passenger passenger) {
		return passengerRepository.save(passenger);
	}
	
	public Passenger viewPassenger(long id) {
		Passenger exist = passengerRepository.findById(id).orElse(null);
		if (exist==null) {
			throw new ResourceNotFoundException("Particular Resource is not found");
		}
		return exist;
	}

}
