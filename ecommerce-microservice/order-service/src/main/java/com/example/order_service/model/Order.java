package com.example.order_service.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Integer quantity;
    
    public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	private LocalDateTime orderDate;
    
    private Long customerId; //reference customer-service, customer entity
    
    private Long productId; // reference product-service , product entity

    // Getters and Setters
    
    
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Order() {
    	super();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "Order [id=" + id +   ", orderDate=" + orderDate + "]";
	}
    
}

