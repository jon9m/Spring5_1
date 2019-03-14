package com.mmk;

import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mmk.hibernate.entity.Course;
import com.mmk.hibernate.entity.Instructor;
import com.mmk.hibernate.entity.InstructorDetail;
import com.mmk.hibernate.entity.Review;
import com.mmk.hibernate.entity.Student;

public class AddInstructorDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();

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

			Review review1 = new Review("Good course 1");
			Review review2 = new Review("Good course 2");

			Student st1 = new Student("first name1", "last name1", "first@stu.com");
			Student st2 = new Student("first name2", "last name2", "second@stu.com");
			Student st3 = new Student("first name3", "last name3", "third@stu.com");
			Student st4 = new Student("first name4", "last name4", "fourth@stu.com");
			Student st21 = new Student("first name21", "last name21", "first2@stu.com");
			Student st22 = new Student("first name22", "last name22", "second2@stu.com");
			Student st23 = new Student("first name23", "last name23", "third2@stu.com");
			Student st24 = new Student("first name24", "last name24", "fourth2@stu.com");

			session.save(st1);
			session.save(st2);
			session.save(st3);
			session.save(st4);
			session.save(st21);
			session.save(st22);
			session.save(st23);
			session.save(st24);

			course1.addStudent(st1);
			course2.addStudent(st1);
			course3.addStudent(st1);
			course4.addStudent(st1);			
					
			course1.addStudent(st2);
			course2.addStudent(st2);
			course3.addStudent(st2);
			
			course1.addStudent(st3);
			course3.addStudent(st3);
			
			course4.addStudent(st4);
			
			
			course1.addStudent(st21);
			
			course1.addStudent(st22);
			course2.addStudent(st22);
			
			course1.addStudent(st23);
			course2.addStudent(st23);
			course3.addStudent(st23);
			
			course1.addStudent(st24);
			course2.addStudent(st24);
			course3.addStudent(st24);
			course4.addStudent(st24);

			course1.addReview(review1);
			course1.addReview(review2);

			instructor.add(course1);
			instructor.add(course2);
			instructor.add(course3);
			instructor.add(course4);

			session.save(instructor);
			
			//test - retrieve all data
			
			/*
			 * Instructor instructor = session.get(Instructor.class, 1);
			 * System.out.println(instructor);
			 * System.out.println(instructor.getInstructorDetail());
			 * System.out.println(instructor.getCourses());
			 * System.out.println(instructor.getCourses().get(0).getReviews());
			 * System.out.println(instructor.getCourses().get(0).getStudents());
			 */

			tx.commit();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
