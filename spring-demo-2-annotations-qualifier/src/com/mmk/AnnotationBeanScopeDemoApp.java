package com.mmk;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
	public static void main(String[] a) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Coach tennisCoach1 = context.getBean("thatSillyCoach", Coach.class);
		Coach tennisCoach2 = context.getBean("thatSillyCoach", Coach.class);

		System.out.println(tennisCoach1.getDailyFortune());
		System.out.println(tennisCoach2.getDailyFortune());

		boolean result = (tennisCoach1 == tennisCoach2);
		System.out.println("Pointing to the same object " + result);

		System.out.println("Memory location of the coach1 " + tennisCoach1);
		System.out.println("Memory location of the coach2 " + tennisCoach2);

		context.close();
	}
}
