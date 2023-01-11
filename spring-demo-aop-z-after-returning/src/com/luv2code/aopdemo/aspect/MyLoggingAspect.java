package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
	
	// add a new advice for @AfterReturning on method: findAccounts()
	
	@AfterReturning(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		
		// print out which method we are advising on....
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n===>>> Executing @AfterReturning on method:  " + method);
		
		// print out the results of the method call
		System.out.println("\n===>>> result is: " + result);
		
		// let's post-process the data... let's modify it :-)
		
		// convert the account names to uppercase....
		covertAccountNamesToUpperCase(result);
		
		System.out.println("\n===>>> result is: " + result);
	}
	
	private void covertAccountNamesToUpperCase(List<Account> result) {
		
		//  loop through the account
		for(Account tempAccount : result) {
			
			// get uppcase version of name
			String theUpperName = tempAccount.getName().toUpperCase();
			
			// update the name on the account
			tempAccount.setName(theUpperName);
		}

		
	}

	// advice for @Before on method: addAccount()
	
	@Before("com.luv2code.aopdemo.aspect.PointcutAopExpressions.forDaoPackageNoGetterSetter()")
	// JoinPoint - this gives us meta data on the method parameters....
	public void performLogging(JoinPoint theJoinPoint) {
		
		System.out.println("\n===>>> Executing @performLogging @Before advice on addAccount()");
		
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
