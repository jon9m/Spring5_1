package com.mmk.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	// Setup Logger
	private Logger myLogger = Logger.getLogger(getClass().getName());

	// Setup pointcut declarations
	@Pointcut("execution(* com.mmk.controller.*.*(..))")
	private void forControllerPackage() {
	}

	@Pointcut("execution(* com.mmk.service.*.*(..))")
	private void forServicePackage() {
	}

	@Pointcut("execution(* com.mmk.dao.*.*(..))")
	private void forDAOPackage() {
	}

	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow() {
	}

	// Add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		// Display method we are calling
		String theMethod = joinPoint.getSignature().toShortString();
		myLogger.info("===========> Before calling the method : " + theMethod);

		// display the arguments
		Object[] args = joinPoint.getArgs();
		for (Object arg : args) {
			myLogger.info("----> argument " + arg);
		}

	}

	// Add @Afterreturnnning advice
	@AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
	public void afterReturning(JoinPoint joinPoint, Object theResult) {
		// Display the method we are returning from
		String theMethod = joinPoint.getSignature().toShortString();
		myLogger.info("***********> After returning the method : " + theMethod);

		// display data returned
		myLogger.info("***********> After returning the result : " + theResult);
	}
}
