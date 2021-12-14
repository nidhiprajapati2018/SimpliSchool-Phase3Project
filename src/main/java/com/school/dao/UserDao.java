package com.school.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.school.entity.User;
import com.school.util.HibernateUtil;


public class UserDao {
	
	public void setUsers() {
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		User s = new User();
		s.setUsername("admin");
		s.setRole("admin");
		s.setPassword("admin");
		session.save(s);
		
		s = new User();
		s.setUsername("guest");
		s.setRole("guest");
		s.setPassword("guest");
		session.save(s);
		
		session.getTransaction().commit();
		session.close();
	}
	
	public int getUserCount() {
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();

		Query<User> query = session.createQuery("from User");

		List<User> result = query.getResultList();
		session.close();
		return result.size();
	}
	
	public void saveUser(User usr) {
		Transaction transaction = null;

		try {
			SessionFactory sf = HibernateUtil.buildSessionFactory();
			Session session = sf.openSession();
			transaction = session.beginTransaction();
			session.save(usr);
			transaction.commit();
			session.close();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public String validate(String username, String password) {
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = null;
		String returnValue = null;
		try {
			tx = session.beginTransaction();
			@SuppressWarnings("unchecked")
			Query<User> query = session.createQuery("from User U where U.username=:username");
			query.setParameter("username", username);

			List<User> result = query.list();
			Iterator<User> iterator = result.iterator();
			User usr = null;
			
			while (iterator.hasNext()) {
				usr = (User) iterator.next();
				if (usr.getPassword().equals(password)) {
					returnValue = usr.getRole();
				}
			}
		} catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
		return returnValue;
	}

}
