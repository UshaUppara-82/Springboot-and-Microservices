package com.mycompany.app.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {
	
	@Bean
	public Animal dog() {
		return new Dog();
		
	}

	
	@Bean
	public Animal cat() {
		return new Cat();
		
	}
	
	@Bean(name="animalService")
	public AnimalService animalService() {
		return new AnimalService();
		
	}
	
	
	@Bean
	public CreditCardPayment creditcard() {
		return new CreditCardPayment();
		
	}
	
	@Bean
	public NetBankingPayment netbanking() {
		return new NetBankingPayment();
		
	}
	
	@Bean(name="paymentProcess")
	public PaymentProcessor paymentProcess() {
		return new PaymentProcessor();
	}
	
	
	@Bean
	public PaymentProcessor paymentProcess1() {
		return new PaymentProcessor();
	}
	
	
	@Bean(name="development")
	@Profile("development")
	public DataSource developmentDataSource() {
		return new DevelopmentDataSource();
	}
	

	@Bean(name="production")
	@Profile("production")
	public DataSource productionDataSource() {
		return new ProductionDataSource();
	}
	
	@Bean
	public DatabaseInitialiser databaseInitialiser() {
		return new DatabaseInitialiser();
	}

}
