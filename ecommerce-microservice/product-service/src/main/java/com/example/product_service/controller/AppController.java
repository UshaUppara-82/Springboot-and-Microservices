package com.example.product_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product_service.model.Product;
import com.example.product_service.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class AppController {

	@Autowired
	ProductService productService;
	
	
	@PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(product));
    }
	
	@GetMapping
	public List<Product> getAllProducts(){
		
		return productService.getAllProducts();
		
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id){
		
		return productService.getProductById(id).get();
		
	}
}
