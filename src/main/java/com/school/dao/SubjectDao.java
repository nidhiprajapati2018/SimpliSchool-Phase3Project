package com.school.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.school.entity.Student;
import com.school.entity.Subject;
import com.school.util.HibernateUtil;

public class SubjectDao {

	public List<Subject> getSubjects() {
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();

		Query<Subject> query = session.createQuery("from Subject");

		List<Subject> result = query.getResultList();
		session.close();
		return result;
	}
	
	public Subject getSubject(long id) {
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();

		Query<Subject> query = session.createQuery("from Subject s WHERE s.subjectid=:id");
		query.setParameter("id", id);
		
		List<Subject> result = query.getResultList();
		session.close();
		Subject s = result.get(0);
		return s;
	}
	
	public int getSubjectCount() {
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();

		Query<Subject> query = session.createQuery("from Subject");

		List<Subject> result = query.getResultList();
		session.close();
		return result.size();
	}

	public void setSubjects() {
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		ArrayList<String> subjects = new ArrayList<String>();
		subjects.add("English");
		subjects.add("Science");
		subjects.add("Math");
		subjects.add("Arts");

		Subject s = null;

		for (int i = 0; i < subjects.size(); i++) {
			s = new Subject();
			s.setSubject(subjects.get(i));
			session.save(s);
		}

		session.getTransaction().commit();
		session.close();
	}
	
	public void deleteSubject(long id) {
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();
		Query<Subject> query = null;
		Transaction transaction = session.beginTransaction();
		query = session.createQuery("delete Subject s where s.subjectid=:id");
		query.setParameter("id", id);
		query.executeUpdate();
		transaction.commit();
		session.close();
	}
	
	
	public void saveSubject(String subject, String grade) {
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();

		Subject subjectObj = new Subject();
		subjectObj.setSubject(subject);
		subjectObj.setGrade(grade);
	
		Transaction tx = session.beginTransaction();
		session.save(subjectObj);
		tx.commit();
		session.close();
	}
	
	public void updateSubject(long id, String subject, String grade) {
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();
		Query<Subject> query = null;
		Transaction transaction = session.beginTransaction();
		
		query = session.createQuery("UPDATE Subject s SET s.subject=:subject, s.grade=:grade WHERE s.subjectid=:id");
		query.setParameter("id", id);
		query.setParameter("subject", subject);
		query.setParameter("grade", grade);
		query.executeUpdate();
		transaction.commit();
		session.close();
	}

}
