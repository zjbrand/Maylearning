package com.eden.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class TimeAspect {
	
	@Pointcut("execution(* com.eden.service.*.*(..))")
	private void pt() {}

	@Around("pt()")
	public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
		
		long begin=System.currentTimeMillis();
		
		Object result = joinPoint.proceed();
		
		long end=System.currentTimeMillis();
		
		log.info(joinPoint.getSignature()+"運行時間：{}ms",end-begin);
		
		return result;
	}
	
	
	
}
