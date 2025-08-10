package com.mycompany.app.model;

public class Country {
	
	private String countryName;
	private State state;
	
	
	public Country(String countryName) {
		this.countryName = countryName;
	}


	public String getCountryName() {
		return countryName;
	}


	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}


	public State getState() {
		return state;
	}


	public void setState(State state) {
		this.state = state;
	}


	@Override
	public String toString() {
		return "Country [countryName=" + countryName + ", state=" + state + "]";
	}


	public Country(State state) {
		super();
		this.countryName="Hyderabad";
		this.state = state;
		System.out.println(" Inside country state constructor");
	}


	

	
	
}
