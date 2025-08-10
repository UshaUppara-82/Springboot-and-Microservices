package com.examples.hibernate.util;

import org.hibernate.cfg.*;
import org.hibernate.service.ServiceRegistry;

import com.examples.hibernate.entity.Student;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		
		try {
	
	Configuration config = new Configuration();
	Properties props = new Properties();
	
	props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
	
	//these has be changed on user db implementation
	props.put(Environment.URL, "jdbc:mysql://localhost:3306/student_hibernate_db?createDatabaseIfNotExist=true");
	props.put(Environment.USER, "root");
	props.put(Environment.PASS, "root");
	
	
	props.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
//props.put(Environment.HBM2DDL_AUTO, "create");
	props.put(Environment.SHOW_SQL, "true");
	
	config.setProperties(props);
	config.addAnnotatedClass(Student.class);
	
	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
	
	sessionFactory = config.buildSessionFactory(serviceRegistry);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
	return sessionFactory;
	
	
	}
}
