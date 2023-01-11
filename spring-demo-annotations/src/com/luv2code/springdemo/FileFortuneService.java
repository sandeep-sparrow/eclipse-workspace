package com.luv2code.springdemo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {

	// load up the file path 
	private String fileName = "C:/Users/Sandeep Prajapati/eclipse-workspace/spring-demo-annotations/src/fortune-data.txt";
	private List<String> theFortunes;
	
	private Random random = new Random();
	
	public FileFortuneService() {
		File theFile = new File(fileName);
		
		System.out.println("Reading fortunes from file: " + theFile);
		System.out.println("File exists: " + theFile.exists());
		
		// initialize array list
		theFortunes = new ArrayList<String>();
		
		// read fortunes from the file 
		try(BufferedReader br = new BufferedReader(
				new FileReader(theFile))){
			
			String tempLine;
			
			while((tempLine = br.readLine()) != null) {
				theFortunes.add(tempLine);
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public String getFortune() {
		// pick a random string from array
		int index = random.nextInt(theFortunes.size());
		String tempFortune = theFortunes.get(index);
		return tempFortune;
	}

}
