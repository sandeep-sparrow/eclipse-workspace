package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	
	private String serviceCode;
	
	public void addAccount(Account account, boolean vipFlag) {
		
		System.out.println(getClass() + " : Doing my DB work : Adding Parent Account!");
		System.out.println("Name of Account: " + account.getName());
		System.out.println("Level of Account: " + account.getLevel());
		System.out.println("\n");
		
	}
	
	// add a new method: findAccounts
	
	public List<Account> findAccounts(boolean tripWire) {
		
		// for academic purpose ... simulate an exception
		if(tripWire) {
			throw new RuntimeException("No Soup for you!!!");
		}
		
		List<Account> myAccounts = new ArrayList<>();
		
		// create sample accounts...
		Account account1 = new Account("John","Silver");
		Account account2 = new Account("Sandeep","Silver");
		Account account3 = new Account("Luka","Gold");
		
		// add those accounts to out list...
		myAccounts.add(account1);
		myAccounts.add(account2);
		myAccounts.add(account3);
		
		return myAccounts;
		
	}
	
	public void addUser() {
		
		System.out.println(getClass() + " : Doing my DB work : Adding User!");
		
	}
	
	public void updateAccount() {
		
		System.out.println(getClass() + " : Doing my DB work : Updating Parent Account!");
		
	}

	public String getName() {
		System.out.println(getClass() + ": doWork() getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": doWork() setName(String name)");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": doWork() getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": doWork() setServiceCode(String serviceCode)");
		this.serviceCode = serviceCode;
	}
	
	
}
