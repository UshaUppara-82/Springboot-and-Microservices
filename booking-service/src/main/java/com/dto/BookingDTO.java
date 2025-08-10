package com.dto;

import java.time.LocalDate;

import com.model.Payment;
import com.util.Status;

public class BookingDTO {

	private long id;// (UUID)
	private CustomerDTO customerId;// (UUID) — Reference to Customer service
	private FlightDTO flightId;// (UUID) — Reference to Flight service
	private LocalDate bookingDate;// (DateTime)
	private String seatNumber;// (String)
	private Status status;// (Enum: Booked, Cancelled, CheckedIn)
	private Payment payment;// (UUID) — Reference to Payment entity 

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public CustomerDTO getCustomerId() {
		return customerId;
	}

	public void setCustomerId(CustomerDTO customerId) {
		this.customerId = customerId;
	}

	public FlightDTO getFlightId() {
		return flightId;
	}

	public void setFlightId(FlightDTO flightId) {
		this.flightId = flightId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status2) {
		this.status = status2;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	
}
