package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.model.NotificationTemplate;

public interface NotificationTemplateRepository extends MongoRepository<NotificationTemplate, String>{

}
