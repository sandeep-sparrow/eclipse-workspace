package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
// it is an aspect
@Component
// it is a component so the annotation config java class can find it using the @ComponentScan("package_name")
public class MyDemoLoggingAspect {
	
	//  this where we add all of our related advices for logging....
	
	// let's start with @Before advice along with point cut expression....
	
	/* execution(modifier-patter? return-type-pattern declaring-type-pattern?
				 method-name-pattern(param-pattern) throws-pattern?)
	
	   @Before("execution(public void addAccount())") - match all the addAccount() method from all the class in the project
	
	   @Before("execution(public void *Account())") - wild card, matched all the method ending with Account() 
	   from all the class in the project
	
	   @Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
	
	   @Before("execution(public void add*())") - wild card matching
	
	   Match on specific return  return type....
	   
	   @Before("execution(void add*())")
	   @Before("execution(boolean add*())")
	   
	   Match on any return type....
	   
	   @Before("execution(* add*())") 

	   @Before("execution(* add*())") 
	   public void beforeAddAccountAdvice()

	*/
	
	@Before("execution(* add*(com.luv2code.aopdemo.Account, ..))") 
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n===>>> Executing @Before advice on add*()\n");
		
	}

}
