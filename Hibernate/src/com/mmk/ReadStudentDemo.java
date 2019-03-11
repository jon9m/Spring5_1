package com.mmk;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mmk.hibernate.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		String theDateOfBirthStr = "31/12/1998";
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		try {
			Student student = new Student("student1", "samaras", "malaka.samaras@gmail.com", DateUtils.parseDate(theDateOfBirthStr));
			Transaction tx = session.beginTransaction();
			session.save(student);
			System.out.println("Primary key of the student after save " + student.getId());
			tx.commit();

			// Retrieve the student
			session = sessionFactory.getCurrentSession();
			Transaction tx2 = session.beginTransaction();
			Student stu = session.get(Student.class, student.getId());
			System.out.println("Retrieved Student " + stu.toString());
			tx2.commit();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}
