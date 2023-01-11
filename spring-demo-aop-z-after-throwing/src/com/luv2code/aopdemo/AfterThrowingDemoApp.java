package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(demoConfig.class);
		
		// get the Accounts bean fromt the container 
		AccountDAO  accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call the business method of beans   
		List<Account> theAccounts = null;
		
		try {
			// add a boolean flag to simulate exceptions...
			boolean tripWire = true;
			theAccounts = accountDAO.findAccounts(tripWire);
		}catch(Exception exc) {
			System.out.println("\nMain Program .... caught Exception: " + exc);
		}
		
		// display the accounts...
		System.out.println("\nMain Program: AfterThrowingDemoApp");
		System.out.println("----");

		System.out.println(theAccounts);
		
		System.out.println("\n");
		
		// close the spring context
		context.close();

	}

}
