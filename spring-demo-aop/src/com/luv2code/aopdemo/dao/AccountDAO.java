package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account account, boolean vipFlag) {
		
		System.out.println(getClass() + " : Doing my DB work : Adding Parent Account!");
		System.out.println("Name of Account: " + account.getName());
		System.out.println("Level of Account: " + account.getLevel());
		System.out.println("\n");
		
	}
	
	public void addUser() {
		
		System.out.println(getClass() + " : Doing my DB work : Adding User!");
		
	}
	
	public void updateAccount() {
		
		System.out.println(getClass() + " : Doing my DB work : Updating Parent Account!");
		
	}
}
