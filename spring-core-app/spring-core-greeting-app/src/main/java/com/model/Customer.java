package com.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Customer {

	int sno;
	String name;
	String email;

	@Autowired
	Address addr;

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}
	//Empty constructor 
	public Customer() {
		super();
	}
	//Parameterized cons
	public Customer(int sno, String name, String email, Address addr) {
		super();
		this.sno = sno;
		this.name = name;
		this.email = email;
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Customer [sno=" + sno + ", name=" + name + ", email=" + email + ", addr=" + addr + "]";
	}

	// methods
	
	
	

}
