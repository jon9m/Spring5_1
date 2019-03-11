package com.mmk;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mmk.hibernate.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		try {
			// Retrieve the student
			int id = 104;
			String firstName = "sam";
			
			session = sessionFactory.getCurrentSession();
			Transaction tx2 = session.beginTransaction();
			
			Student stu = session.get(Student.class, id);
			stu.setFirstName(firstName);
			
			tx2.commit();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}