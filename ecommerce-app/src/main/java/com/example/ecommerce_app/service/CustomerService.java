package com.example.ecommerce_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.example.ecommerce_app.exception.ResourceNotFoundException;
import com.example.ecommerce_app.model.Customer;
import com.example.ecommerce_app.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;

	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.save(customer);
		
		
	}

	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	public Customer getCustomerById(Long id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Optional<Customer> c = customerRepository.findById(id);
		if(c.isPresent()){
			return c.get();
		}else {
			throw new ResourceNotFoundException("Customer not found with '"+id+"'");
		}
		
	}

	public void deleteCustomer(Long id) {
		// TODO Auto-generated method stub
		
		customerRepository.deleteById(id);
		
	}
	
	

}
