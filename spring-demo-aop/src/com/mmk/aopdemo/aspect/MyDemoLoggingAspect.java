package com.mmk.aopdemo.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	// this is where we add all our related advices for logging	

	// @AddBefore advice
//	@Before("execution(public void addAccount())")
//	@After("execution(public void addAccount())")
	@Around("execution(public void addAccount())")
//	@AfterReturning("execution(public void addAccount())")
//	@("execution(public void addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("===== Executing Before Advice =====");
	}
}
