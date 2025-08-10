package com.mycompany.app.model;

import com.mycompany.app.model.Person;

public class Employee  extends Person{
	
	int employeeNumber;
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	Address address;
	

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	@Override
	public String toString() {
		return "Employee [employeeNumber=" + employeeNumber + ", address=" + address + ", getName()=" + getName() + "]";
	}

	
	

}