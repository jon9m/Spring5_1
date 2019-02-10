package com.mmk;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] a) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Coach sillyCoach = context.getBean("thatSillyCoach", Coach.class);
		System.out.println(sillyCoach.getDailyWorkout());

		context.close();
	}
}
