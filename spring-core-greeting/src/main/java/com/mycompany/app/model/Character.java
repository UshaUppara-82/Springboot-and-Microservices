package com.mycompany.app.model;

import org.springframework.beans.factory.InitializingBean;

public class Character implements InitializingBean {
	private int id;
	private String name;
	public Character() {
		
	}
	public Character(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void init() {
		System.out.println("Character is going thro' init");
	}
	public void destroy() {
		System.out.println(" Character will destroy now");
	}
	
	  @Override public void afterPropertiesSet() throws Exception {
		  // TODO 	  Auto-generated method stub
	 
	  System.out.println(" Character props are set ");
	  
	  }
	 
}
