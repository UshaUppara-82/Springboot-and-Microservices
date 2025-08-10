package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import com.util.*;

@Entity
public class Passenger {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;// (UUID)

	@ManyToOne
	private Booking booking;// (UUID)

	private String name;// (String)
	private int age;// (Integer)
	
	@Enumerated(EnumType.STRING)
	private gender gender;// (Enum: Male, Female, Other)
	
	private String passportNumber;// (String)
	private String  nationality;// (String)
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public gender getGender() {
		return gender;
	}
	public void setGender(gender gender) {
		this.gender = gender;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	

}
