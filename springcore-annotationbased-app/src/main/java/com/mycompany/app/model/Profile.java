package com.mycompany.app.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Profile {
	
	@Autowired
	private Student student;
	
	public Profile() {
		System.out.println(" Inside Profile constructor");
		//student=new Student();
	}
	
	
	public void showDetails() {
		System.out.println(" Stud Id : "+student.getStudId() + " \t name : "+student.getName());
	}


	@Override
	public String toString() {
		return "Profile [student=" + student + "]";
	}
	
	
}
