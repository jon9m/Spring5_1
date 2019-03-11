package com.mmk;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mmk.hibernate.entity.Instructor;
import com.mmk.hibernate.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		String theDateOfBirthStr = "31/12/1998";
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		try {
			// Create the Objects
			Instructor instructor = new Instructor("jon", "sam", "jon@sam.com");
			InstructorDetail instructorDetail = new InstructorDetail("http://jonsam.com", "code");

			// Associate objects
			instructor.setInstructorDetail(instructorDetail);

			Transaction tx = session.beginTransaction();

			// Save objects
			session.save(instructor);

			tx.commit();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
