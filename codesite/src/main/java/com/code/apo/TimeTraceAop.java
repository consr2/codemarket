package com.code.apo;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Aspect
@Component
public class TimeTraceAop {
	
	@Around("execution(* com.code..*Controller.*(..))")
	public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
		//Long start = System.currentTimeMillis();
		try {
			String method = joinPoint.getSignature().getName();
			String clazz = joinPoint.getTarget().getClass().getName();
			log.info("실행 위치 : " + clazz + "-" + method + "()");
			return joinPoint.proceed();
		} finally {
			//Long finish = System.currentTimeMillis();
			//Long timeMs = finish - start;
			//System.out.println("END : " + joinPoint.toString() + " " + timeMs + "ms");
		}
	}

}
