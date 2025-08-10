package com.example.ecommerce_app_rest_api.repository;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce_app_rest_api.model.Order;

@Repository

public interface OrderRepository  extends JpaRepository<Order, Long> {

}
