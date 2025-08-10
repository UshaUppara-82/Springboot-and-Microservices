package com.mycompany.app;

public class Car {
	private int platNo;
	private String ownerName;
	private String location;
	
	private Engine engine;

	public int getPlatNo() {
		return platNo;
	}

	public void setPlatNo(int platNo) {
		this.platNo = platNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Car [platNo=" + platNo + ", ownerName=" + ownerName + ", location=" + location + ", engine=" + engine
				+ "]";
	}
	
	

}
