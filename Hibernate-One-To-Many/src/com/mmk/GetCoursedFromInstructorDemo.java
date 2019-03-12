package com.mmk;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mmk.hibernate.entity.Course;
import com.mmk.hibernate.entity.Instructor;
import com.mmk.hibernate.entity.InstructorDetail;

public class GetCoursedFromInstructorDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		try {
			Transaction tx = session.beginTransaction();

			Instructor instructor = session.get(Instructor.class, 2);

			System.out.println("Courses " + instructor.getCourses());

			tx.commit();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
