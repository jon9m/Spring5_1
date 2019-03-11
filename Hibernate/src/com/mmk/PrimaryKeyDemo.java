package com.mmk;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mmk.hibernate.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		String theDateOfBirthStr = "31/12/1998";
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		try {
			Student student1 = new Student("malaka1", "samaras1", "malaka1.samaras@gmail.com", DateUtils.parseDate(theDateOfBirthStr));
			Student student2 = new Student("malaka2", "samaras2", "malaka2.samaras@gmail.com", DateUtils.parseDate(theDateOfBirthStr));
			Student student3 = new Student("malaka3", "samaras3", "malaka3.samaras@gmail.com", DateUtils.parseDate(theDateOfBirthStr));
			
			Transaction tx = session.beginTransaction();
						
			session.save(student1);
			session.save(student2);
			session.save(student3);
									
			tx.commit();		
		
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
