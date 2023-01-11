package com.luv2code.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	
	// add new fields for email address and team
	private String emailAddress;
	private String team;
	
	// generate setter for the properties
	
	
	// create no-arg constructor
	public CricketCoach() {
		System.out.println("Cricket Coach: inside no-arg Constructor");
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("Cricket Coach: inside setter method - setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("Cricket Coach: inside setter method - setTeam");
		this.team = team;
	}

	// setter method -> which is called by spring when injection happens
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Cricket Coach: inside setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		
		return "Practice Fast bowling for 15 mintues";
	}

	@Override
	public String getDailyFortune() {
		
		return "Cricket Lovers! " + fortuneService.getFortune();
	}
	
	

}
