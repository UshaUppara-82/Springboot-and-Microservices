package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.ResourceNotFoundException;
import com.model.Airport;
import com.repository.AirportRepository;

@Service
public class AirportService {
	
	@Autowired
	AirportRepository airportRepository;
	
	public Airport saveAirport(Airport airport) {
		return airportRepository.save(airport);
	}
	
	public Airport viewAirport(long id) {
		Airport exist = airportRepository.findById(id).orElse(null);
		if (exist==null) {
			throw new ResourceNotFoundException("Particular Resource is not found");
		}
		return exist;
	}

}
