package com.mmk;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mmk.hibernate.entity.Instructor;
import com.mmk.hibernate.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		try {
			Transaction tx = session.beginTransaction();
			
//			session.createQuery("delete from Instructor where id = 1").executeUpdate();  //Doen't work cascade deletion
			
			Instructor toDelete = session.get(Instructor.class, 2);
			session.delete(toDelete);

			tx.commit();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
