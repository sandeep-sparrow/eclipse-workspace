package com.luv2code.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	public TrackCoach() {
		
	}
	public TrackCoach(FortuneService fortuneService) {
		System.out.println("Track Coach: inside Constructor");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		System.out.println("Track Coach: inside getDailyWorkout");
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {

		System.out.println("Cricket Coach: inside getDailyFortune");
		return "Just do it " + fortuneService.getFortune();
	}
	
	// add an init method
	public void doMyStartUpStuff() {
		System.out.println("Track Coach: inside method doMyStartupStuff");
	}
	
	// add an destroy method
	public void doMyCleanUpStuff() {
		System.out.println("Track Coach: inside method doMyCleanUpStuff");
	}

}
