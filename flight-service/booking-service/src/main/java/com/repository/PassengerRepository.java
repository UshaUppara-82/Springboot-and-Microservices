package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
