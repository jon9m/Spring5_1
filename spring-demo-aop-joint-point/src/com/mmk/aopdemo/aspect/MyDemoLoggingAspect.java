package com.mmk.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	// this is where we add all our related advices for logging

	// @AddBefore advice
	@Before("execution(public void addAccount())")
//	@After("execution(public void addAccount())")
//	@Around("execution(public void addAccount())")
//	@AfterReturning("execution(public void addAccount())")
//	@("execution(public void addAccount())")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("===== Executing Before Advice 1 =====");
		System.out.println("----- Join Point details -------");
		System.out.println("Target- " + joinPoint.getTarget());
		System.out.println("Method- " + joinPoint.getSignature());
	}

	@Around("execution(public void addAccount(..))")
	public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		long begin = System.currentTimeMillis();
		proceedingJoinPoint.proceed();
		long end = System.currentTimeMillis();
		System.out.println("Duration " + (end - begin) + " milliseconds");
	}

	// Pointcut declaration
	@Pointcut("execution(public void addAccount(..))")
	private void forDaoPackage() {
	}

	@Before("forDaoPackage()")
	public void beforeAddAccountAdviceUsingPointCutDeclaraion() {
		System.out.println("===== Executing Before Advice 1 Using PointCut Declaraion =====");
	}
}
