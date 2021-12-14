package com.school.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.school.entity.Student;
import com.school.util.HibernateUtil;

public class StudentDao {
	
	public List<Student> getStudents() {
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();
		Query<Student> query = session.createQuery("from Student");
		
		List<Student> result = query.getResultList();
		session.close();
		return result;
	}

	public Student getStudent(long id) {
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();
		Query<Student> query = session.createQuery("from Student s WHERE s.student_id=:id");
		query.setParameter("id", id);
		
		List<Student> result = query.getResultList();
		session.close();
		Student s = result.get(0);
		return s;
	}
	
	public void updateStudent(long id, String fname, String lname, String grade, String status) {
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();
		Query<Student> query = null;
		Transaction transaction = session.beginTransaction();
		
		query = session.createQuery("UPDATE Student s SET s.fname=:fname, s.lname=:lname, s.grade=:grade, s.status=:status WHERE s.student_id=:id");
		query.setParameter("id", id);
		query.setParameter("fname", fname);
		query.setParameter("lname", lname);
		query.setParameter("grade", grade);
		query.setParameter("status", status);
		query.executeUpdate();
		transaction.commit();
		session.close();
	}
	
	public void deleteStudent(long id) {
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();
		Query<Student> query = null;
		Transaction transaction = session.beginTransaction();
		query = session.createQuery("delete Student s where s.student_id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
		transaction.commit();
		session.close();
	}

	public void saveStudent(String fname, String lname, String grade, String status) {
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();

		Student student = new Student();
		student.setFname(fname);
		student.setLname(lname);
		student.setGrade(grade);
		student.setStatus(status);

		Transaction tx = session.beginTransaction();
		session.save(student);
		tx.commit();
		session.close();
	}
}
