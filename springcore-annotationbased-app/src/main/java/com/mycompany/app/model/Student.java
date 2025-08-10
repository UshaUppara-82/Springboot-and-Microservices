package com.mycompany.app.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
	
	@Value(value="101")
	private Integer studId;
	
	@Value(value="Srikanth")
	private String name;
	public Integer getStudId() {
		return studId;
	}
	public void setStudId(Integer studId) {
		this.studId = studId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [studId=" + studId + ", name=" + name + "]";
	}
	
	
	
	

}
