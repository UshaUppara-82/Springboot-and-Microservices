package com.mycompany.app.model;

import org.springframework.stereotype.Component;

@Component("dog")
public class Dog  implements Animal{

	@Override
	public void makeSound() {
		// TODO Auto-generated method stub
		System.out.println("Woof");
		
	}

}
