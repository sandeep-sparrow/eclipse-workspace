package com.java.learn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
	
	public static Connection getConnection() {
		
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false", "root", "root");
		}catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return connection;
		
	}

}
