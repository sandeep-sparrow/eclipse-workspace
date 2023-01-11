package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

	public FootballCoach() {
		System.out.println(">> FootballCoach: inside default constructor");
	}
	@Override
	public String getDailyWorkout() {
		return "Dribble for 1k Yard";
	}

	@Override 
	public String getDailyFortune() {
		return "This is your fortune from football coach";
	}

}
