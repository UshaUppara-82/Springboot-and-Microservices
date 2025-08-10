package com.mycompany.app.model;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Profile;

@Component
@Profile("development")
public class DevelopmentDataSource  implements DataSource{

	@Override
	public void connect() {
		// TODO Auto-generated method stub
		
		System.out.println(" Connected to development database");
		
	}
	

}
