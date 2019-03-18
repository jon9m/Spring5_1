package com.mmk.aopdemo.aspect;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect2 {
	// this is where we add all our related advices for logging	

	// @AddBefore advice
	@Before("execution(public void addAccount())")
//	@After("execution(public void addAccount())")
//	@Around("execution(public void addAccount())")
//	@AfterReturning("execution(public void addAccount())")
//	@("execution(public void addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("===== Executing Before Advice 2 =====");
	}
	
	
	//Pointcut declaration
	@Pointcut("execution(public void addAccount())")
	private void forDaoPackage() {}
	
	@Before("forDaoPackage()")
	public void beforeAddAccountAdviceUsingPointCutDeclaraion() {
		System.out.println("===== Executing Before Advice 2 Using PointCut Declaraion =====");
	}
}
