package com.example.order_service.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.order_service.dto.CustomerDTO;
import com.example.order_service.dto.ProductDTO;
import com.example.order_service.feign.ProductClient;
import com.example.order_service.model.Order;
import com.example.order_service.repository.OrderRepository;

@Service

public class OrderService {

	private static final String CUSTOMER_SERVICE_URL = "http://localhost:2222/api/customers";

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired 
	private ProductClient productClient;

	public Order createOrder(Long customerId) {

		Order order = new Order();
		order.setOrderDate(LocalDateTime.now());
		order.setCustomerId(customerId);

		return orderRepository.save(order);
	}

	public String placeOrder(Long customerId) {

		CustomerDTO customer = getCustomerDetails(customerId);
		if (customer != null) {
			Order order = new Order();
			order.setOrderDate(LocalDateTime.now());
			order.setCustomerId(customer.getId());

			orderRepository.save(order);

		}
		return "Order placed for Customer: " + customer.getName();
	}

	public CustomerDTO getCustomerDetails(Long customerId) {

		// http://localhost:2222/api/customers/1
		return restTemplate.getForObject(CUSTOMER_SERVICE_URL + "/" + customerId, CustomerDTO.class);
	}

	public Order createOrderWithProduct(Long productId, Integer quanity) {
		// TODO Auto-generated method stub
		ProductDTO product = productClient.getProductById(productId);
		Order order = new Order();
		order.setOrderDate(LocalDateTime.now());
		order.setProductId(product.getId());
		order.setQuantity(quanity);

		orderRepository.save(order);
		
		return order;
	}
}
