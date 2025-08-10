package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.ResourceNotFoundException;
import com.model.Customer;
import com.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public Customer viewCustomer(long id) {
		Customer exist = customerRepository.findById(id).orElse(null);
		if (exist==null) {
			throw new ResourceNotFoundException("Particular Resource is not found");
		}
		return exist;
	}

}
