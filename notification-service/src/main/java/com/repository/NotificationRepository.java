package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.model.Notification;

public interface NotificationRepository extends MongoRepository<Notification, String>{
	public Notification findBynotificationId(long id);
}
