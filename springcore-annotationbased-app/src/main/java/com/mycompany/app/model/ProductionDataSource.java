package com.mycompany.app.model;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("production")
public class ProductionDataSource implements DataSource{

	@Override
	public void connect() {
		// TODO Auto-generated method stub
		System.out.println(" Connected to production database");
	}
	

}
