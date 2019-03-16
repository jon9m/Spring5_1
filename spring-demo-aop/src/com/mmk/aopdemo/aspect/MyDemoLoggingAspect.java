package com.mmk.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	// this is where we add all our related advices for logging

	// @AddBefore advice
	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("===== Executing Before Advice =====");
	}
}
