package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

}

