package com.mycompany.app.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {
	
	@Autowired
	@Qualifier("dog") //Specify which bean to be injected
	private Animal animal;
	
	
	
	public AnimalService() {
		super();
		
	}
	

	public void makeSound() {
		animal.makeSound();
	}
}
