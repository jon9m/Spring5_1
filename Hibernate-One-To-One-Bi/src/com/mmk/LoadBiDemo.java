package com.mmk;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mmk.hibernate.entity.Instructor;
import com.mmk.hibernate.entity.InstructorDetail;

public class LoadBiDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		try {
			Transaction tx = session.beginTransaction();
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, 9);
//			System.out.println(instructorDetail.getInstructor());   //LAZY
			System.out.println(instructorDetail);	//EAGER

			tx.commit();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
