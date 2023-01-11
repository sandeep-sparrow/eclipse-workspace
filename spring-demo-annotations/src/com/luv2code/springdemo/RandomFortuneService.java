package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	// create an array of strings 
	private String[] Data = 
			{
			"Beware of the wolf in sheeps clothing",
			"Diligence is the mother of good luck",
			"The journey is the reward"
			};
	
	// create an random number generated
	private Random random = new Random();
	
	@Override
	public String getFortune() {
		
		// pick a random string from Array: Data
		int rnd = random.nextInt(Data.length);
		
		return "RandomService Say's Today is your luck day " + Data[rnd];
	}

}
