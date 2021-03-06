package com.mmk.aopdemo.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	// this is where we add all our related advices for logging	

	// @AddBefore advice
//	@Before("execution(public void addAccount())")
//	@After("execution(public void addAccount())")
//	@Around("execution(public void addAccount())")
	@AfterReturning("execution(public void addAccount(..))")
//	@("execution(public void addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("===== Executing Advice =====");
	}
	
	
	//Pointcut declaration
	@Pointcut("execution(public void addAccount())")
	private void forDaoPackage() {}
	
	@Before("forDaoPackage()")
	public void beforeAddAccountAdviceUsingPointCutDeclaraion() {
		System.out.println("===== Executing Advice Using PointCut Declaraion =====");
	}
}
