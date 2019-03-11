package com.mmk;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mmk.hibernate.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		try {
			Transaction tx = session.beginTransaction();

//			List<Student> students = session.createQuery("from Student").getResultList();
//			List<Student> students = session.createQuery("from Student where id > 3").getResultList();
//			List<Student> students = session.createQuery("from Student s where  s.firstName='student1'").getResultList();
//			List<Student> students = session.createQuery("from Student s where  s.firstName='student1' OR s.firstName='malaka'").getResultList();
			List<Student> students = session.createQuery("from Student s where  s.firstName like '%dent1'").getResultList();
			System.out.println(students);

//			List<Object[]> students = session.createQuery("select firstName, id from Student").getResultList();
//			for (Object[] stu : students) {
//				System.out.println(stu[0] + " : " + stu[1]);
//			}

			tx.commit();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
