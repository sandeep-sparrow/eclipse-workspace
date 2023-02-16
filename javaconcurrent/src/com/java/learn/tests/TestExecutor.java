package com.java.learn.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.java.learn.dao.UserDAO;
import com.java.learn.runnables.UserProcessor;

public class TestExecutor {
	
	public static void main(String[] args) {
		
		ExecutorService service = Executors.newFixedThreadPool(5);
		String fileName = "C:\\Users\\Sandeep Prajapati\\OneDrive\\Desktop\\test.txt";
		
		List<String> users = getUsersFromFile(fileName);
		
		UserDAO userDAO = new UserDAO();
		
		for(String user : users) {
			Future<Integer> future =
					service.submit(new UserProcessor(user, userDAO));
			try {
				System.out.println("Result of the operation: " + future.get());
			}catch (Exception ex) {
				Logger.getLogger(TestExecutor.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		
	}
	
	public static List<String> getUsersFromFile(String fileName){
		List<String> users = new ArrayList<>();
		
		try(BufferedReader br = 
				new BufferedReader(new FileReader(new File(fileName)))){
			String line = null;
			while((line=br.readLine())!=null) {
				users.add(line);
			}
		}catch (FileNotFoundException ex) {
			Logger.getLogger(TestExecutor.class.getName()).log(Level.SEVERE, null, ex);
		}catch (IOException ex) {
			Logger.getLogger(TestExecutor.class.getName()).log(Level.SEVERE, null, ex);
		}
		return users;
		
	}

}
