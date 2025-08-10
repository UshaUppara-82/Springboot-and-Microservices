package com.example.ecommerce_app_rest_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce_app_rest_api.exception.CustomerNotFoundException;
import com.example.ecommerce_app_rest_api.model.Customer;
import com.example.ecommerce_app_rest_api.model.Order;
import com.example.ecommerce_app_rest_api.model.Payment;
import com.example.ecommerce_app_rest_api.model.Product;
import com.example.ecommerce_app_rest_api.service.CustomerService;
import com.example.ecommerce_app_rest_api.service.OrderService;
import com.example.ecommerce_app_rest_api.service.PaymentService;
import com.example.ecommerce_app_rest_api.service.ProductService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class AppController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	PaymentService paymentService;
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomer(){
		return customerService.getAllCustomers();
	}

	@PostMapping("/customers")
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) throws CustomerNotFoundException{
		Customer customer = customerService.getCustomerById(id);
		if(customer == null) {
			throw new CustomerNotFoundException("Customer not found with '"+id+"'");
		}
		return  new ResponseEntity<Customer>(customer,HttpStatus.OK) ;
	}
	
	@PutMapping("/customers/{id}")
	public Customer updateCustomer(@RequestBody Customer customer, @PathVariable Long id) throws CustomerNotFoundException {
		Customer existingCustomer = customerService.getCustomerById(id);
    	existingCustomer.setName(customer.getName());
    	existingCustomer.setPassword(customer.getPassword());
    	existingCustomer.setEmail(customer.getEmail());
    	
    	Customer result = customerService.saveCustomer(existingCustomer);
    	
    	return result;
		
		
		
	}
	@DeleteMapping("/customers/{id}")
	public String deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);
		return "Customer deleted with this "+id;
	}
	
	
	@GetMapping("/customers/byName/{name}")
	public ResponseEntity<?> getCustomerByName(@PathVariable String name) throws CustomerNotFoundException {
		/*
		 * Customer c = customerService.getCustomerByName(name); if(c!= null) { return
		 * ResponseEntity.status(HttpStatus.CREATED).body(c); } return
		 * ResponseEntity.status(HttpStatus.CREATED).body(new
		 * RuntimeException("Customer Not found"));
		 */
		
		Customer c = customerService.getCustomerByName(name);
		if(c == null) {
			throw new CustomerNotFoundException("Customer not found with '"+name+"'");
		}
		 return ResponseEntity.status(HttpStatus.CREATED).body(c);
	}
	@GetMapping("/customers/byNameAndEmail/{name}")
	public Customer getCustomerByName(@PathVariable String name, @RequestParam String email) {
		return customerService.getCustomerByNameAndEmail(name,email);
	}
	
	@GetMapping("/customers/byNameStarts/{prefix}")
	public List<Customer> getCustomerByNameStartsWith(@PathVariable String prefix) {
		return customerService.getCustomerByNameStartsWith(prefix);
	}
	
	@GetMapping("/customers/byCountNameStarts/{prefix}")
	public long countCustomerByNameStartsWith(@PathVariable String prefix) {
		return customerService.countCustomerByNameStartsWith(prefix);
	}
	
	@GetMapping("/customers/byDomain/{domain}")
	public List<Customer> getCustomersByDomain(@PathVariable String domain) {
		return customerService.getCustomersByDomain(domain);
	}
	
	@GetMapping("/customers/minAgeCustomer")
	public Customer getMinAgeCustomer() {
		return customerService.getMinAgeCustomer();
	}
	
	@PostMapping("/orders")
    public ResponseEntity<Order> createOrder(@RequestParam Long customerId) throws CustomerNotFoundException {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(customerId));
    }
	@PostMapping("/payments")
    public ResponseEntity<Payment> createPayment(@RequestParam Long orderId, @RequestParam Double amount) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.createPayment(orderId, amount));
    }
	@PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(product));
    }
	@PostMapping("/orders/map")
    public ResponseEntity<Order> createOrder(@RequestParam Long customerId, @RequestBody List<Long> productIds) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrderWithProducts(customerId, productIds));
    }
	
	
}
