package com.mmk;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mmk.hibernate.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		try {
			Student student = new Student("malaka", "samaras", "malaka.samaras@gmail.com");
			Transaction tx = session.beginTransaction();
			session.save(student);
			tx.commit();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
