package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(demoConfig.class);
		
		// get the Accounts bean fromt the container 
		AccountDAO  accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call the business method of beans   
		List<Account> theAccounts = accountDAO.findAccounts(true);
		
		// display the accounts...
		System.out.println("\nMain Program: AfterReturningDemoApp");
		System.out.println("----");

		System.out.println(theAccounts);
		
		System.out.println("\n");
		
		// close the spring context
		context.close();

	}

}
