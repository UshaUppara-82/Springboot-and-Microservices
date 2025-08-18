package com.example.driver_service.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String licenseNumber;
    private String phoneNumber;
    private String email;
    private AvailabilityStatus availabilityStatus; 
    
    private Long vehicleId; 
	@CreationTimestamp
    private LocalDateTime createdAt;
	   @UpdateTimestamp
    private LocalDateTime updatedAt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public AvailabilityStatus getAvailabilityStatus() {
		return availabilityStatus;
	}
	public void setAvailabilityStatus(AvailabilityStatus availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}
	public Long getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Driver(Long id, String name, String licenseNumber, String phoneNumber, String email,
			AvailabilityStatus availabilityStatus, Long vehicleId, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.licenseNumber = licenseNumber;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.availabilityStatus = availabilityStatus;
		this.vehicleId = vehicleId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public Driver() {
		super();
	}
	@Override
	public String toString() {
		return "Driver [id=" + id + ", name=" + name + ", licenseNumber=" + licenseNumber + ", phoneNumber="
				+ phoneNumber + ", email=" + email + ", availabilityStatus=" + availabilityStatus + ", vehicleId="
				+ vehicleId + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
    
}