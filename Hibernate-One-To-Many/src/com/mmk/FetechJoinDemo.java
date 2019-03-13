package com.mmk;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.mmk.hibernate.entity.Course;
import com.mmk.hibernate.entity.Instructor;
import com.mmk.hibernate.entity.InstructorDetail;

public class FetechJoinDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		try {
			Transaction tx = session.beginTransaction();

//			Query query = session.createQuery("select i from Instructor i where id=2", Instructor.class);
			Query query = session.createQuery(
							  "select i from Instructor i " 
							+ "JOIN FETCH i.courses where i.id=:theInstructorId",
					Instructor.class);

			query.setParameter("theInstructorId", 2);
			
			Instructor instructor = (Instructor) query.getSingleResult();			
			System.out.println(instructor);
			
			tx.commit();
			
			//After session is closed
			System.out.println("After session is closed");
			session.close();
			System.out.println(instructor.getCourses());
			
		} finally {
			if (session.isOpen()) {
				session.close();
			}
			sessionFactory.close();
		}
	}

}
