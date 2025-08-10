package com.example.payment_service.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Payment {
	@Id
	private String id;
    
    
    private Double amount;
    private String status;
    private LocalDateTime paymentDate;

    // Getters and Setters
    
    public Payment() {
    	super();
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", amount=" + amount + ", status=" + status + ", paymentDate="
				+ paymentDate + "]";
	}
    
    


}
