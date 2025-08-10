package com.example.payment_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.payment_service.model.Payment;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, String> {

}
