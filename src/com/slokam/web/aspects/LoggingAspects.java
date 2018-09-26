package com.slokam.web.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspects {

	/*private long startTime;
	private long endTime;*/
	
	@Before("execution (* com.slokam.web.*.*.*(..))")
	public void beforeEveryMethod(JoinPoint jp){
		String methodName=jp.getSignature().getName();
		String objName=jp.getTarget().toString();
		//startTime=System.currentTimeMillis();
		System.out.println("Before method."+methodName+":::"+objName);
		
	}
	
	@After("execution (* com.slokam.web.*.*.*(..))")
	public void afterEveryMethod(JoinPoint jp){
		String methodName=jp.getSignature().getName();
		String objName=jp.getTarget().toString();
		//endTime=System.currentTimeMillis();
		System.out.println("After method..::"+methodName+":::"+objName);
		//long totalTime=endTime-startTime;
		/*System.out.println("total execution time=="+totalTime);*/
		
	}
}
