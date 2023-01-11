package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
// it is an aspect
@Component
// it is a component so the annotation config java class can find it using the @ComponentScan("package_name")
public class MyDemoLoggingAspect {
	
	//  this where we add all of our related advices for logging....
	
	// let's start with @Before advice along with point cut expression....

	// create a point cut declaration
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage( ) {}
	
	@Before("forDaoPackage()") 
	public void addLoggingInformation() {
		
		System.out.println("\n===>>> Executing @addLoggingInformation advice on addAccount()\n");
		
	}
	
	@Before("forDaoPackage()")
	public void addAnalyticsApi() {
		
		System.out.println("\n===>>> Executing @addAnalyticsApi advice on addAccount()\n");
		
	}

}
