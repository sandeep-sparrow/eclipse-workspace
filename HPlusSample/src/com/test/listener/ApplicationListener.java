package com.test.listener;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.test.dao.DBConnection;

public class ApplicationListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// parameter is ServletContextEvent object
		System.out.println("In contextDestroyed method");
		Connection connection = (Connection) sce.getServletContext().getAttribute("dbConnection");
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("In contextInitialized  Method");
		Connection connection = DBConnection.getConnectionToDatabase();
		if(connection == null) {
			System.out.println("Connection is null!");
		}else {
			System.out.println(connection);
		}
		sce.getServletContext().setAttribute("dbConnection", connection);
	}

}
