package com.luv2code.springdemo;

public class WrestlingCoach implements Coach {

	// dependency
	private FortuneService fortuneService;
	
	// constructor injection
	public WrestlingCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice your leg Kick 25 minutes";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
