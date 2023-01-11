package com.luv2code.springdemo;

import java.util.Random;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		String[] fortuneMessages = {"Today, is your lucky day! Your have won 1000$",
				                    "Today, is your lucky day! Your have won 2000$",
				                    "Today, is your lucky day! Your have won 3000$"};
		int rnd = new Random().nextInt(fortuneMessages.length);
		return fortuneMessages[rnd];
	}

}
