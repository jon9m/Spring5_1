package com.mmk;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mmk.hibernate.entity.Course;
import com.mmk.hibernate.entity.Instructor;
import com.mmk.hibernate.entity.InstructorDetail;

public class AddInstructorDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		try {
			Transaction tx = session.beginTransaction();

			Instructor instructor = new Instructor("susan", "public", "susan@public.com");
			InstructorDetail instructorDetail = new InstructorDetail("Gaming.com", "Video Games");
			instructor.setInstructorDetail(instructorDetail);

			Course course1 = new Course("Game Developmet", instructor);
			Course course2 = new Course("Android Game Developmet", instructor);
			Course course3 = new Course("C# Developmet", instructor);
			Course course4 = new Course("C++ Developmet", instructor);

			instructor.add(course1);
			instructor.add(course2);
			instructor.add(course3);
			instructor.add(course4);

			session.save(instructor);

			tx.commit();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
