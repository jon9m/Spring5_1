package com.mmk.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mmk.coach.Coach;

public class BeanLifeCycleDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
				
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		// close the context
		context.close();
	}

}







