package com.mmk.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mmk.aopdemo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		// Read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// Get the bean
		AccountDAO dao = context.getBean("accountDAO", AccountDAO.class);

		// call business method
		dao.addAccount();
		dao.addAccount();

		// close context
		context.close();
	}

}
