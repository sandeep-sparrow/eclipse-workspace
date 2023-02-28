package com.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection getConnectionToDatabase() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("MySql JDBC Driver Registered!");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hplus?useSSL=false","root","root");
		}catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
		}catch (SQLException e) {
			System.out.println("Connection Failed! Check output console!");
			e.printStackTrace();
		}
		
		if(connection!=null) {
			System.out.println("Connection made to DB");
		}
		return connection;
	}

}
