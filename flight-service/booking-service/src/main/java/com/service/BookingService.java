package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dto.*;
import com.exception.ResourceNotFoundException;
import com.model.*;
import com.repository.*;

@Service
public class BookingService {
	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	PaymentRepository paymentRepository;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	CircuitBreakerFactory circuitBreakerFactory;

	private final String FLIGHT_URL = "http://localhost:1010/flight";
	private final String AIRPORT_URL = "http://localhost:1010/airport";
	private final String CUSTOMER_URL = "http://localhost:1010/customer";
	private final String FREQ_FLYER_URL = "http://localhost:1010/frequentflyer";

	public Booking saveBooking(Booking booking) {
		/*
		 * Payment result = paymentRepository.getById(booking.getPayment().getId());
		 * booking.setPayment(result);
		 */return bookingRepository.save(booking);
	}

	public Booking viewBooking(long id) {
		Booking exist = bookingRepository.findById(id).orElse(null);
		if (exist == null) {
			throw new ResourceNotFoundException("Particular Resource is not found");
		}
		return exist;
	}

	public List<Booking> viewAllBooking() {

		return bookingRepository.findAll();
	}

	public BookingDTO viewDetails(long id) {

		Booking booking = viewBooking(id);

		CustomerDTO customer = getCustomer(booking.getCustomerId());
		FlightDTO flight = getFlight(booking.getFlightId());

		BookingDTO response = new BookingDTO();
		response.setBookingDate(booking.getBookingDate());
		response.setCustomerId(customer);
		response.setFlightId(flight);
		response.setId(booking.getId());
		response.setPayment(booking.getPayment());
		response.setSeatNumber(booking.getSeatNumber());
		response.setStatus(booking.getStatus());

		return response;
	}

	public CustomerDTO getCustomer(long id) {
		return circuitBreakerFactory.create("customerdb").run(
				() -> restTemplate.getForObject(CUSTOMER_URL + "/" + id, CustomerDTO.class),
				throwable -> customerFallBack(id, throwable));
	}

	public CustomerDTO customerFallBack(long id, Throwable ex) {
		return new CustomerDTO(id, "Unknown Name (fallback)", "Unknown Name (fallback)", "Unknown Email (fallback)",
				"Unknown Phone Number (fallback)", null, 0);
	}

	public FlightDTO getFlight(long id) {
		return circuitBreakerFactory.create("flightdb").run(
				() -> restTemplate.getForObject(FLIGHT_URL + "/" + id, FlightDTO.class),
				throwable -> flightFallBack(id, throwable));
	}

	public FlightDTO flightFallBack(long id, Throwable ex) {
		return new FlightDTO(id, "Unknown Flight Number (fallback)", null, null, null, null, 0, 0, "Unknown Status");
	}

}
