package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		SwimCoach theSwimCoach = context.getBean("swimCoach", SwimCoach.class); 
		
		System.out.println(theSwimCoach.getDailyWorkout());
		System.out.println(theSwimCoach.getDailyFortune());
		System.out.println("Email: " +theSwimCoach.getEmail());
		System.out.println("Team : " +theSwimCoach.getTeam());
		
		context.close();

	}

}
