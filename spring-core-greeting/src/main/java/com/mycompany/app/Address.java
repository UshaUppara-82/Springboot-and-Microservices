package com.mycompany.app;

public class Address {
	
	private String streetName;
	private String doorName;
	private String location;
	private String pinCode;
	
	public Address() {
		
	}
	
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getDoorName() {
		return doorName;
	}
	public void setDoorName(String doorName) {
		this.doorName = doorName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Address [streetName=" + streetName + ", doorName=" + doorName + ", location=" + location + ", pinCode="
				+ pinCode + "]";
	}

	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	
	
	
	

}

