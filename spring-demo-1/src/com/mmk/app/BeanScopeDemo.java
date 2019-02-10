package com.mmk.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mmk.coach.Coach;

public class BeanScopeDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
				
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(alphaCoach.getDailyWorkout());
		
		boolean result = (theCoach == alphaCoach);
		
		System.out.println("Memory location for the coach " + theCoach);
		System.out.println("Memory location for the alphaCoach " + alphaCoach);
		System.out.println("Pointing to the same object " + result);
		
		// close the context
		context.close();
	}

}







