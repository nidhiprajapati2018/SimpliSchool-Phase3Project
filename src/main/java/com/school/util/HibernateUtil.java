package com.school.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.school.entity.*;

public class HibernateUtil {
	
	public static SessionFactory buildSessionFactory() {
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(Subject.class)
				.addAnnotatedClass(User.class)
				.buildSessionFactory();
		return sessionFactory;
	}
}