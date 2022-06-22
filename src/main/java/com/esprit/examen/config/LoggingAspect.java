package com.esprit.examen.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	private static final Logger l = LogManager.getLogger(LoggingAspect.class);

	@Before("execution(* com.esprit.examen.services.*.*(..))")
	public void logMethodEntry(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		l.info("In method " + name + " : ");
	}

	@After("execution(* com.esprit.examen.services.*.*(..))")
	public void logMethodExit(JoinPoint joinPoint){
		String name = joinPoint.getSignature().getName();
		l.info("Out of method  :"+name);
	}

	@Around("execution(* com.esprit.examen.services.*.*(..))")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		Object obj = pjp.proceed();
		long elapsedTime = System.currentTimeMillis() - start;
		l.info("Method execution time: " + elapsedTime + " milliseconds.");
		return obj;
	}
}
