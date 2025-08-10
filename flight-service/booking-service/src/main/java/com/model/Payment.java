package com.model;

import java.math.BigDecimal; 
import java.time.LocalDate;

import com.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;// (UUID)
	
	private BigDecimal amount;// (Decimal)
	private LocalDate paymentDate;// (DateTime)
	
	@Enumerated(EnumType.STRING)
	private paymentMethod paymentMethod;// (Enum: CreditCard, DebitCard, PayPal)
	
	@Enumerated(EnumType.STRING)
	private paymentStatus paymentStatus;// (Enum: Success, Failed, Pending)
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	public paymentMethod getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(paymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public paymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(paymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	

		

}
