package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach theCoach = context.getBean("pingPongCoach", Coach.class);
		// Coach footballCoach = context.getBean("footballCoach", Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		// System.out.println(footballCoach.getDailyWorkout());
		// System.out.println(footballCoach.getFortune());
		
		context.close();

	}

}
