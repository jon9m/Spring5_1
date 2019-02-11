package com.mmk;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] a) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Coach sillyCoach = context.getBean("thatSillyCoach", Coach.class);
		System.out.println(sillyCoach.getDailyWorkout());
		System.out.println(sillyCoach.getDailyFortune());

		System.out.println("--------------------------");

		Coach sillySetterCoach = context.getBean("sillySetterCoach", Coach.class);
		System.out.println(sillySetterCoach.getDailyWorkout());
		System.out.println(sillySetterCoach.getDailyFortune());

		System.out.println("--------------------------");

		Coach sillyMethodCoach = context.getBean("sillyMethCoach", Coach.class);
		System.out.println(sillyMethodCoach.getDailyWorkout());
		System.out.println(sillyMethodCoach.getDailyFortune());

		System.out.println("--------------------------");

		Coach sillyFieldCoach = context.getBean("sillyFieldCoach", Coach.class);
		System.out.println(sillyFieldCoach.getDailyWorkout());
		System.out.println(sillyFieldCoach.getDailyFortune());

		context.close();
	}
}
