package com.mycompany.app.model;

import javax.annotation.PostConstruct;

public class DatabaseInitialiser {
	
	@PostConstruct
	public void init() {
		
		System.out.println(" Initialising the database ....");
		//steps for db initialization
		System.out.println(" the database initialized successfully!");
	}

	//other methods
}
