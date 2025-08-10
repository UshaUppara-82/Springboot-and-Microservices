package com.example.ecommerce_app_rest_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce_app_rest_api.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Optional<Product> findByName(String name);

}
