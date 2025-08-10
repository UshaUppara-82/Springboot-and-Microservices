package com.mycompany.app.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mycompany.app.model.Address;
import com.mycompany.app.model.Author;
import com.mycompany.app.model.Country;
import com.mycompany.app.model.Employee;
import com.mycompany.app.model.Mentor;
import com.mycompany.app.model.State;

@Configuration
public class ApplicationConfiguration {
	
	@Bean(name="countryObj")
	public Country getCountry() {
		System.out.println(" inside getCountry method");
		return new Country("India");
	}

	
	@Bean
	public Author getAuthor() {
		Author author = new Author();
		author.setAuthorName("Craig Wallis");
		author.setAuthorAddress("Denton");
		
		return author;
	}
	
	@Bean
	public Mentor getMentor() {
		
		Mentor mentor = new Mentor();
		mentor.setMid(456);
		mentor.setNm("Jyoti");
		
		List modules = new ArrayList<String>();
		modules.add("HTML");
		modules.add("Java");
		modules.add("SPRING");
		
		mentor.setModules(modules);
		
		return mentor;
		
		
	}
	
	
	@Bean
	public Employee getEmployee() {
		Employee emp = new Employee();
		emp.setEmployeeNumber(4589);
		emp.setName("John");
		Address addr = getAddress();
		emp.setAddress(addr);
		
		return emp;
	}
	
	@Bean
	public Address getAddress() {
		
		Address addr = new Address();
		addr.setDoorName("45");
		addr.setStreetName("XXX");
		addr.setLocation("Chennai");
		addr.setPinCode("785212");
		
		return addr;
		
	}
	
	@Bean
	public State getState() {
		State state = new State();
		state.setStateName("Telegana");
		state.setRegion("South");
		return state;
	}
	
	@Bean(name="getCountryWithState")
	public Country getCountryWithState() {
		State state = getState();
		Country country = new Country(state);
		
		return country;
	}
}


