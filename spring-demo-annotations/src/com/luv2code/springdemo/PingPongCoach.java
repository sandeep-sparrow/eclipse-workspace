package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PingPongCoach implements Coach {

	@Autowired
	/* the Autowired annotations create the default dependency
	   (a single java class which implements FortuneService) and constructs 
	   a constructor(PingPongCoach(FortuneService fortuneService))
	   for injection automtically
	*/ 
	@Qualifier("fileFortuneService")
	// Qualifies the specified dependent java class which implements FortuneService
	private FortuneService fortuneService;
	
	public PingPongCoach() {
		System.out.println(">> PingPongCoach: inside default constructor");
	}
	@Override
	public String getDailyWorkout() {
		return "Practice your pingpong drop shot";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	

}
