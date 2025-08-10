package com.mycompany.app;

public class Employee  extends Person{
	
	int employeeNumber;
	
	/*
	 * private String streetName; private String doorName; private String location;
	 * private String pinCode;
	 */
	
	
	//Property based injection/setter based injection - define the address object reference as one of the property in Employee class
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	@Override
	public String toString() {
		return "Employee [employeeNumber=" + employeeNumber + ", address=" + address + "]";
	}
	
	

}
