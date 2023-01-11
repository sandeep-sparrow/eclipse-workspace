package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService {

	public DatabaseFortuneService() {
		System.out.println(">> DatabaseFortuneService defined constructor");
	}
	@Override
	public String getFortune() {
		return "DatabaseFortuneService Say's Today is your luck day";
	}

}
