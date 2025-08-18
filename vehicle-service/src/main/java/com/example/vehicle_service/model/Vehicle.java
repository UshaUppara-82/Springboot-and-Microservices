package com.example.vehicle_service.model;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long vehicleId;
	
	private String vehicleNumber;
	private Integer capacity;
	
	
	private VehicleType vehicleType;
	   
	
	private VehicleStatus vehicleStatus;
	   
	@CreationTimestamp
	private Timestamp createdAt;
	
    @UpdateTimestamp
	private Timestamp updatedAt;

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public VehicleStatus getVehicleStatus() {
		return vehicleStatus;
	}

	public void setVehicleStatus(VehicleStatus vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Vehicle(Long vehicleId, String vehicleNumber, Integer capacity, VehicleType vehicleType,
			VehicleStatus vehicleStatus, Timestamp createdAt, Timestamp updatedAt) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleNumber = vehicleNumber;
		this.capacity = capacity;
		this.vehicleType = vehicleType;
		this.vehicleStatus = vehicleStatus;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Vehicle() {
		super();
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", vehicleNumber=" + vehicleNumber + ", capacity=" + capacity
				+ ", vehicleType=" + vehicleType + ", vehicleStatus=" + vehicleStatus + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}
    
}