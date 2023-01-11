package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeBeanScopeDemoApp {

	public static void main(String[] args) {
		
		// load the spring container in context object
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanScope-ApplicationContext.xml");
		
		// retrieve bean from the spring container 
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		// check the result
		boolean result = (theCoach == alphaCoach);
		
		System.out.println("\nPointing to the same object: " +result);
		System.out.println("\nMemory Location of the theCoach: " +theCoach);
		System.out.println("\nMemory Location of the alphaCoach: " +alphaCoach);
		
		// close the container
		context.close();

	}

}
