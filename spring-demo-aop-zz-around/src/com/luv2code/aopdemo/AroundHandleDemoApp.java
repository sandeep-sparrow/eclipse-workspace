package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundHandleDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(demoConfig.class);
		
		// get the Accounts bean fromt the container 
		TrafficFortuneService  theTrafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("\nMain Program: AroundDemoApp");
		System.out.println("Calling getFortune");
		String data = theTrafficFortuneService.getFortune();
		System.out.println("\nMy Fortune is: " + data);
		System.out.println("Finished!");
		
		// close the spring context
		context.close();

	}

}
