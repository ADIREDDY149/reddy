package com.slokam.web.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodExcecutionTime {

	
	@Around("execution (* com.slokam.web.*.*.*(..))")
	public Object methodExecutionTime(ProceedingJoinPoint pjp){
		
		
		String methodName=pjp.getSignature().getName();
		String objName=pjp.getTarget().toString();
		long startTime=System.currentTimeMillis();
		System.out.println("StartTime::"+startTime+"::is,"+methodName+"for::"+objName);
		Object obj=null;
		try {
			 obj=pjp.proceed();//we are going to call target method i.e may be service or dao or controller
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long endTime=System.currentTimeMillis();
		System.out.println("EndTime::"+endTime+"::is,"+methodName+"for::"+objName);
		long totalTime=endTime-startTime;
		
		System.out.println("Time taken by metod Execution time::"+totalTime+":::is,"+methodName+"for::"+objName);
		
		
		return obj;

		
		
	}
}
