package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.ResourceNotFoundException;
import com.model.Flight;
import com.repository.FlightRepository;

@Service
public class FlightService {
	
	@Autowired
	FlightRepository flightRepository;
	
	public Flight saveFlight(Flight flight) {
		return flightRepository.save(flight);
	}
	
	public Flight viewFlight(long id) {
		Flight exist = flightRepository.findById(id).orElse(null);
		if (exist==null) {
			throw new ResourceNotFoundException("Particular Resource is not found");
		}
		return exist;
	}

}
