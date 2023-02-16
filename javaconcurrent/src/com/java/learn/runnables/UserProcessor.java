package com.java.learn.runnables;

import java.util.StringTokenizer;
import java.util.concurrent.Callable;

import com.java.learn.beans.User;
import com.java.learn.dao.UserDAO;

public class UserProcessor implements Callable<Integer> {

	private String userRecord;
	private UserDAO userDAO;
	
	public UserProcessor(String userRecord, UserDAO userDAO) {
		this.userRecord = userRecord;
		this.userDAO = userDAO;
	}

	@Override
	public Integer call() throws Exception {
		int rows = 0;
		System.out.println(Thread.currentThread().getName()+ " processing record for " + userRecord);
		StringTokenizer tokenizer = new StringTokenizer(userRecord,",");
		User user = null;
		while(tokenizer.hasMoreElements()) {
			user = new User();
			user.setEmail(tokenizer.nextToken());
			user.setName(tokenizer.nextToken());
			user.setId(Integer.parseInt(tokenizer.nextToken()));
			rows = userDAO.saveUser(user);
		}
		return rows;
	}

}
