package com.mmk;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mmk.hibernate.entity.Student;

public class UpdateAllStudentDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		try {
			session = sessionFactory.getCurrentSession();
			Transaction tx2 = session.beginTransaction();

			session.createQuery("update Student set lastName='samaras'").executeUpdate();

			tx2.commit();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}