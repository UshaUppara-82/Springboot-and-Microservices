package com.mycompany.app.model;

import org.springframework.context.Lifecycle;

//this is a POJO class
public class Customer implements Lifecycle {

	private int cno;
	private String cname;
	private double orderValue;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer(int cno, String cname, double orderValue) {
		super();
		this.cno = cno;
		this.cname = cname;
		this.orderValue = orderValue;
	}

	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public double getOrderValue() {
		return orderValue;
	}
	public void setOrderValue(double orderValue) {
		this.orderValue = orderValue;
	}

	@Override
	public String toString() {
		return "Customer [cno=" + cno + ", cname=" + cname + ", orderValue=" + orderValue + "]";
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println(" Customer component is started ");
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isRunning() {
		// TODO Auto-generated method stub
		return false;
	}	
	
}
