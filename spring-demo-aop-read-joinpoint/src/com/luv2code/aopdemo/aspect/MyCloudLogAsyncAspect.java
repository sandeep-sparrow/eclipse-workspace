package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class MyCloudLogAsyncAspect {

	
	@Before("com.luv2code.aopdemo.aspect.PointcutAopExpressions.forDaoPackageNoGetterSetter()") 
	public void performLogToCloudAsync() {
		
		System.out.println("\n===>>> Executing @performLogToCloudAsync @Before advice on addAccount()\n");
		
	}
}
