package com.example.booking_service.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
@Entity
public class Booking {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long bookingId;

	    private String customerName;
	    private String contactNumber;

	    private Long routeId;  
	    private Long vehicleId; 
	    private Long driverId;  

	    @Enumerated(EnumType.STRING)
	    private BookingStatus bookingStatus;

	    private LocalDateTime bookingTime;
		
	    private LocalDateTime startTime;
	
	    private LocalDateTime endTime;
		@CreationTimestamp
	    private LocalDateTime createdAt;
		@UpdateTimestamp
	    private LocalDateTime updatedAt;
	    
	    @PrePersist
	    protected void onCreate() {
	        createdAt = LocalDateTime.now();
	        bookingTime = LocalDateTime.now(); 
	    }

	    @PreUpdate
	    protected void onUpdate() {
	        updatedAt = LocalDateTime.now();
	    }
		public Long getBookingId() {
			return bookingId;
		}
		public void setBookingId(Long bookingId) {
			this.bookingId = bookingId;
		}
		public String getCustomerName() {
			return customerName;
		}
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		public String getContactNumber() {
			return contactNumber;
		}
		public void setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
		}
		public Long getRouteId() {
			return routeId;
		}
		public void setRouteId(Long routeId) {
			this.routeId = routeId;
		}
		public Long getVehicleId() {
			return vehicleId;
		}
		public void setVehicleId(Long vehicleId) {
			this.vehicleId = vehicleId;
		}
		public Long getDriverId() {
			return driverId;
		}
		public void setDriverId(Long driverId) {
			this.driverId = driverId;
		}
		public BookingStatus getBookingStatus() {
			return bookingStatus;
		}
		public void setBookingStatus(BookingStatus bookingStatus) {
			this.bookingStatus = bookingStatus;
		}
		public LocalDateTime getBookingTime() {
			return bookingTime;
		}
		public void setBookingTime(LocalDateTime bookingTime) {
			this.bookingTime = bookingTime;
		}
		public LocalDateTime getStartTime() {
			return startTime;
		}
		public void setStartTime(LocalDateTime startTime) {
			this.startTime = startTime;
		}
		public LocalDateTime getEndTime() {
			return endTime;
		}
		public void setEndTime(LocalDateTime endTime) {
			this.endTime = endTime;
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
		public Booking(Long bookingId, String customerName, String contactNumber, Long routeId, Long vehicleId,
				Long driverId, BookingStatus bookingStatus, LocalDateTime bookingTime, LocalDateTime startTime,
				LocalDateTime endTime, LocalDateTime createdAt, LocalDateTime updatedAt) {
			super();
			this.bookingId = bookingId;
			this.customerName = customerName;
			this.contactNumber = contactNumber;
			this.routeId = routeId;
			this.vehicleId = vehicleId;
			this.driverId = driverId;
			this.bookingStatus = bookingStatus;
			this.bookingTime = bookingTime;
			this.startTime = startTime;
			this.endTime = endTime;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
		}
		public Booking() {
			super();
		}
		@Override
		public String toString() {
			return "Booking [bookingId=" + bookingId + ", customerName=" + customerName + ", contactNumber="
					+ contactNumber + ", routeId=" + routeId + ", vehicleId=" + vehicleId + ", driverId=" + driverId
					+ ", bookingStatus=" + bookingStatus + ", bookingTime=" + bookingTime + ", startTime=" + startTime
					+ ", endTime=" + endTime + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
		}
	    
	    

}
