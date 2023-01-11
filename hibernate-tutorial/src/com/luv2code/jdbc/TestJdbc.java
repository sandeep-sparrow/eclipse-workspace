package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcurl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		// TODO Auto-generated method stub
		try {
			System.out.println("Connecting to Database! " + jdbcurl);
			
			Connection myConn = 
					DriverManager.getConnection(jdbcurl, user, pass);
			
			System.out.println("Connection Successfull!");
			myConn.close();
			System.out.println("Connection Closed Successfully!");
			
		}catch(Exception ex){
			ex.printStackTrace();
			
		}
	}

}
