package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Airport;

public interface AirportRepository extends JpaRepository< Airport, Long> {

}
