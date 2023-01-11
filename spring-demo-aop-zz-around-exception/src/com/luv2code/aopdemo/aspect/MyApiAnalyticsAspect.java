package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(3)
@Component
public class MyApiAnalyticsAspect {

	// add new advice for @After (finally) method...
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		// print out which method we are advising on....
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n===>>> Executing MyApiAnalyticsAspect @After (finally) on method:  " + method);
		
		// print out the results of the method call
		System.out.println("\n===>>> result is: " + theJoinPoint);
		
		
	}
	
	@Before("com.luv2code.aopdemo.aspect.PointcutAopExpressions.forDaoPackageNoGetterSetter()") 
	public void performApiAnalytics() {
		
		System.out.println("\n===>>> Executing @performApiAnalytics @Before advice on addAccount()");
		
	}
}
