package com.code.apo;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

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
		Long start = System.currentTimeMillis();
		try {
			String method = joinPoint.getSignature().getName();
			String clazz = joinPoint.getTarget().getClass().getName();
			return joinPoint.proceed();
		} finally {
			Long finish = System.currentTimeMillis();
			Long timeMs = finish - start;
			
			String homedir = System.getProperty("user.dir");
			String fileName = homedir + File.separator + "AopLog.txt";
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
			bw.write("END : " + joinPoint.toString() + " " + timeMs + "ms\n");
			bw.flush();
			bw.close();

		}
	}

}
