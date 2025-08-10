package com.dto;

import java.time.LocalDateTime;


public class FlightDTO {
	
	 private long id;// (UUID)
	 private String flightNumber;
	 private AirportDTO departureAirport;
	 private AirportDTO arrivalAirport;
	 private LocalDateTime departureTime ;//(DateTime)
	 private LocalDateTime arrivalTime;// (DateTime)
	 private int seatCapacity;// (Integer)
	 private int availableSeats;// (Integer)
	 private String status;//
	 
	 
	 
	 
	 
	public FlightDTO(long id, String flightNumber, AirportDTO departureAirport, AirportDTO arrivalAirport,
			LocalDateTime departureTime, LocalDateTime arrivalTime, int seatCapacity, int availableSeats,
			String status) {
		super();
		this.id = id;
		this.flightNumber = flightNumber;
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.seatCapacity = seatCapacity;
		this.availableSeats = availableSeats;
		this.status = status;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public AirportDTO getDepartureAirport() {
		return departureAirport;
	}
	public void setDepartureAirport(AirportDTO departureAirport) {
		this.departureAirport = departureAirport;
	}
	public AirportDTO getArrivalAirport() {
		return arrivalAirport;
	}
	public void setArrivalAirport(AirportDTO arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}
	public LocalDateTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}
	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public int getSeatCapacity() {
		return seatCapacity;
	}
	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	 
	
}
