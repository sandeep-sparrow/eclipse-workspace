package com.luv2code.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {

	// define a array
	private String[] data = {"Beware of the wolf in sheep's clothing",
			                 "Diligence is the mother of good luck",
			                 "The journey is the reward"};
	
	// create a random number generator 
	private Random random = new Random();
	
	@Override
	public String getFortune() {
		// pick a random string from Data
		int index = random.nextInt(data.length);
		
		String theFortune = data[index];
		
		return theFortune;
		
	}

}
