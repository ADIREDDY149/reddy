package com.slokam.web.aspects;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterReturning1 {
@AfterReturning(pointcut="execution(* com.slokam.web.test.*.get*(..))",returning="obj")
	public Object testAfterReturning(JoinPoint jp,Object obj){
	String methodName=	jp.getSignature().getName();
	String className=jp.getTarget().toString();
		System.out.println("After Returning=="+obj+"::"+methodName+"::classname=="+className);
		return obj;
		
		
	}
}
