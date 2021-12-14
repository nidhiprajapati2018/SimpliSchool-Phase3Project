package com.school.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.school.entity.Teacher;
import com.school.util.HibernateUtil;

public class TeacherDao {
	
	public List<Teacher> getTeachers() {
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();
		Query<Teacher> query = session.createQuery("from Teacher");
		
		List<Teacher> result = query.getResultList();
		session.close();
		return result;
	}

	public Teacher getTeacher(long id) {
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();
		Query<Teacher> query = session.createQuery("from Teacher t WHERE t.teacherid=:id");
		query.setParameter("id", id);
		
		List<Teacher> result = query.getResultList();
		session.close();
		Teacher s = result.get(0);
		return s;
	}
	
	public void updateTeacher(long id, String fname, String lname, String let, String set, String phone, String email) {
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();
		Query<Teacher> query = null;
		Transaction transaction = session.beginTransaction();
		
		query = session.createQuery("UPDATE Teacher t SET t.fname=:fname, t.lname=:lname, t.let=:let, t.set=:set, t.phone=:phone, t.email=:email WHERE t.teacherid=:id");
		query.setParameter("id", id);
		query.setParameter("fname", fname);
		query.setParameter("lname", lname);
		query.setParameter("let", let);
		query.setParameter("set", set);
		query.setParameter("phone", phone);
		query.setParameter("email", email);
		query.executeUpdate();
		transaction.commit();
		session.close();
	}
	
	public void deleteTeacher(long id) {
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();
		Query<Teacher> query = null;
		Transaction transaction = session.beginTransaction();
		query = session.createQuery("delete Teacher t where t.teacherid=:id");
		query.setParameter("id", id);
		query.executeUpdate();
		transaction.commit();
		session.close();
	}

	public void saveTeacher(String fname, String lname, String let, String set, String phone, String email) {
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();

		Teacher teacher = new Teacher();
		teacher.setFname(fname);
		teacher.setLname(lname);
		teacher.setLet(let);
		teacher.setSet(set);
		teacher.setPhone(phone);
		teacher.setEmail(email);

		Transaction tx = session.beginTransaction();
		session.save(teacher);
		tx.commit();
		session.close();
	}
}
