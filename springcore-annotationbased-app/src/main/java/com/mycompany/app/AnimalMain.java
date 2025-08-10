package com.mycompany.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mycompany.app.model.AnimalService;
import com.mycompany.app.model.AppConfig;
import com.mycompany.app.model.DataSource;
import com.mycompany.app.model.DatabaseInitialiser;
import com.mycompany.app.model.DevelopmentDataSource;
import com.mycompany.app.model.PaymentProcessor;
import com.mycompany.app.model.ProductionDataSource;

public class AnimalMain {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
			
		  AnimalService service = (AnimalService) context.getBean("animalService");
		  service.makeSound();
		  
		  
		  AnimalService service1 = (AnimalService) context.getBean(AnimalService.class);
		  service1.makeSound();
		  
		  
		  PaymentProcessor processor = (PaymentProcessor) context.getBean("paymentProcess");
		  processor.processPayment();
		  
		  context.getEnvironment().setActiveProfiles("production");
		  context.register(DevelopmentDataSource.class, ProductionDataSource.class);
		//  context.refresh();
		  DataSource dataSource = (DataSource) context.getBean(DataSource.class);
		  dataSource.connect();
		  
//		  DatabaseInitialiser initialiser = context.getBean(DatabaseInitialiser.class);
//		  System.out.println(initialiser);
		  
		  
		  ((AbstractApplicationContext) context).close();
	}

}
