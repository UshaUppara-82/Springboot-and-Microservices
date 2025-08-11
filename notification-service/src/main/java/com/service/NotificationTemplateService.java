package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.ResourceNotFoundException;
import com.model.NotificationTemplate;
import com.repository.NotificationTemplateRepository;

@Service
public class NotificationTemplateService {
	
	@Autowired
	NotificationTemplateRepository notificartionTemplateRepository;
	
	public NotificationTemplate saveNotificationTemplate(NotificationTemplate notificartionTemplate) {
		return notificartionTemplateRepository.save(notificartionTemplate);
	}
	
	public NotificationTemplate viewNotificationTemplate(String id) {
		NotificationTemplate exist = notificartionTemplateRepository.findById(id).orElse(null);
		if (exist==null) {
			throw new ResourceNotFoundException("Particular Resource is not found");
		}
		return exist;
	}

}
