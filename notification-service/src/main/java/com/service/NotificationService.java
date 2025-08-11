package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dto.*;
import com.exception.ResourceNotFoundException;
import com.model.Notification;
import com.repository.NotificationRepository;


@Service
public class NotificationService {
	
	@Autowired
	NotificationRepository notificationRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	CircuitBreakerFactory circuitBreakerFactory;
	
	private final String CUSTOMER_URL="http://localhost:1010/customer" ;
	
	
	public Notification saveNotification(Notification notification) {
		return notificationRepository.save(notification);
	}
	
	public Notification viewNotification(String id) {
		Notification exist = notificationRepository.findById(id).orElse(null);
		if (exist==null) {
			throw new ResourceNotFoundException("Particular Resource is not found");
		}
		return exist;
	}
	
	public Notification viewNotificationByCustomId(long id) {
		Notification exist = notificationRepository.findBynotificationId(id);
		return exist;
	}
	
	
	
	public NotificationDTO viewDetails(long id) {
		
		Notification notification = viewNotificationByCustomId(id);
		
		CustomerDTO customer = getCustomer(id);
		NotificationDTO newNotification = new NotificationDTO();
		newNotification.setCustomer(customer);
		newNotification.setMessage(notification.getMessage());
		newNotification.setNotificationId(notification.getNotificationId());
		newNotification.setSentDate(notification.getSentDate());
		newNotification.setSentStatus(notification.getSentStatus());
		newNotification.setType(notification.getType());
		
	
		return newNotification;
		
	}
	
	
	public CustomerDTO getCustomer(long id) {
		return circuitBreakerFactory.create("customerdb").run(() ->  restTemplate.getForObject(CUSTOMER_URL+"/"+id, CustomerDTO.class), throwable -> customerFallBack(id, throwable));	
	}
	
	public CustomerDTO customerFallBack(long id, Throwable ex) {
		return new CustomerDTO(id, "Unknown Name (fallback)", "Unknown Name (fallback)", "Unknown Email (fallback)","Unknown Phone Number (fallback)", null, 0);
	}
	

}
