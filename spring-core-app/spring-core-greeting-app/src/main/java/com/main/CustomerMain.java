package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.Address;
import com.model.Customer;

public class CustomerMain {
	public static void main(String[] args) {
		//load the context
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		//Fetch the bean
		Customer cust = (Customer) context.getBean("customer");
		
		//access the variables, methods 
		System.out.println(cust.getName());
		
		
		Address address = context.getBean(Address.class);
		//access the variables, methods 
				System.out.println(address.getCityName());
				
		
		
		
		
	}
}
