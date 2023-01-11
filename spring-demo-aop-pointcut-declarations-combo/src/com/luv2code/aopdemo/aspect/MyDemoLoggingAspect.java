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
	
	// create a getter point cut declaration
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	public void forGetter() {}
	
	// create a setter point cut declaration
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	public void forSetter() {}
	
	// create pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(forGetter() || forSetter())")
	public void forDaoPackageNoGetterSetter() {}
	
	@Before("forDaoPackageNoGetterSetter()") 
	public void addLoggingInformation() {
		
		System.out.println("\n===>>> Executing @addLoggingInformation advice on addAccount()\n");
		
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void addAnalyticsApi() {
		
		System.out.println("\n===>>> Executing @addAnalyticsApi advice on addAccount()\n");
		
	}

}
