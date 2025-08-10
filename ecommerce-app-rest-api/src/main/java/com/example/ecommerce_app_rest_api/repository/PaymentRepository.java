package com.example.ecommerce_app_rest_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce_app_rest_api.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
