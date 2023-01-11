package com.luv2code.springdemo;

public class MmxCoach implements Coach {

	private FortuneService fortuneService;
	
	public MmxCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {

		return "Buckle up you mouth strains";
	}

	@Override
	public String getDailyFortune() {

		return fortuneService.getFortune();
	}

}
