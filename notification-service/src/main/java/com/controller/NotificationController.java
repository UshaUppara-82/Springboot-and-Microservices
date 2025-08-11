package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.model.*;
import com.service.*;

@RestController
@RequestMapping("/notification")
public class NotificationController {
	
	@Autowired
	NotificationService notificationService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addNotification(@RequestBody Notification notification){
		return new ResponseEntity<> (notificationService.saveNotification(notification), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> viewNotification(@PathVariable String id){
		return new ResponseEntity<> (notificationService.viewNotification(id), HttpStatus.OK);
	}
	
	@GetMapping("/details/{id}")
	public ResponseEntity<?> viewNotificationDetails(@PathVariable long id){
		return new ResponseEntity<> (notificationService.viewDetails(id), HttpStatus.OK);
	}
	
	
	@Autowired
	NotificationTemplateService notificationTemplateService;
	
	@PostMapping("/template/add")
	public ResponseEntity<?> addNotificationTemplate(@RequestBody NotificationTemplate notificationTemplate){
		return new ResponseEntity<> (notificationTemplateService.saveNotificationTemplate(notificationTemplate), HttpStatus.OK);
	}
	
	@GetMapping("/template/{id}")
	public ResponseEntity<?> viewNotificationTemplate(@PathVariable String id){
		return new ResponseEntity<> (notificationTemplateService.viewNotificationTemplate(id), HttpStatus.OK);
	}

}
