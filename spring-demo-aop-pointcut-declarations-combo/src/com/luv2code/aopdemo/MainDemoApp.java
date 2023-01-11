package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(demoConfig.class);
		
		// get the Accounts bean fromt the container 
		AccountDAO  accountDAO = context.getBean("accountDAO", AccountDAO.class);
		// get the Membership bean fromt the container 
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		// call the business method of beans
		
		Account myAccount = new Account("sandeep","Level 4");
		
		accountDAO.addAccount(myAccount, true);
		accountDAO.addUser();
		accountDAO.updateAccount();
		
		// setter and getter example for point cut explaination
		
		System.out.println("\n");
		accountDAO.setName("sandeep");
		accountDAO.setServiceCode("HDFC0000398");
		accountDAO.getName();
		accountDAO.getServiceCode();
		
		// call the business method for membership...
		
		membershipDAO.addAccount();
		membershipDAO.addMember();
		
		// close the spring context
		context.close();

	}

}
