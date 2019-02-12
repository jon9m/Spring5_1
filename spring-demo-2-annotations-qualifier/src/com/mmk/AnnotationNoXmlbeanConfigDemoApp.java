package com.mmk;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationNoXmlbeanConfigDemoApp {

	public static void main(String[] a) {
		AnnotationConfigApplicationContext context 
			= new AnnotationConfigApplicationContext(NoXmlBeanConfig.class);

		Coach swimCoach = context.getBean("swimCoach", Coach.class);
		System.out.println(swimCoach.getDailyWorkout());
		System.out.println(swimCoach.getDailyFortune());


		context.close();
	}
}
