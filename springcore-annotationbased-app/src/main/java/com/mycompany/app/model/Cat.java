package com.mycompany.app.model;

import org.springframework.stereotype.Component;

@Component("cat")
public class Cat implements Animal {

	@Override
	public void makeSound() {
		// TODO Auto-generated method stub
		System.out.println("Meow");
		
	}

}
