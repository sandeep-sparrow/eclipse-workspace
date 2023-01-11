package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Order(2)
@Component
public class MyLoggingAspect {
	
	@Before("com.luv2code.aopdemo.aspect.PointcutAopExpressions.forDaoPackageNoGetterSetter()")
	// JoinPoint - this gives us meta data on the method parameters....
	public void performLogging(JoinPoint theJoinPoint) {
		
		System.out.println("\n===>>> Executing @performLogging @Before advice on addAccount()\n");
		
		// display the method signature
		MethodSignature methodSig =(MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method: " +methodSig);
		
		// display the metod arguments 
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		// loop through args
		for(Object tempArg : args) {
			System.out.println(tempArg);
			
			if(tempArg instanceof Account) {
				// downcast and print account specific stuff
				Account theAccount = (Account) tempArg;
				
				System.out.println("Account Name: " + theAccount.getName());
				System.out.println("Account Level: " + theAccount.getLevel());
				
			}
		}
		
	}
	
}
