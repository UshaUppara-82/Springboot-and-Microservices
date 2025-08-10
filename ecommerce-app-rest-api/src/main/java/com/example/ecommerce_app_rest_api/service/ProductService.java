package com.example.ecommerce_app_rest_api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce_app_rest_api.model.Product;
import com.example.ecommerce_app_rest_api.repository.ProductRepository;

@Service
public class ProductService {
	
	 @Autowired
	    private ProductRepository productRepository;

	    public Product createProduct(Product product) {
	        return productRepository.save(product);
	    }

	    public Optional<Product> getProductByName(String name) {
	        return productRepository.findByName(name);
	    }
	    public Optional<Product> getProductById(Long name) {
	    	
	        return productRepository.findById(name);
	    }

}
