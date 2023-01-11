package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addAccount() {
		
		System.out.println(getClass() + " : Doing my DB work : Adding Membership Account !");
	}
	
	public boolean addMember() {
		
		System.out.println(getClass() + " : Doing my DB work : Adding Member!");
		
		return true;
	}

}
