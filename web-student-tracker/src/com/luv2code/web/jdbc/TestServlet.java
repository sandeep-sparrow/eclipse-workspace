package com.luv2code.web.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestServlet() {
        super();
    }

    // Define data source / connection pool for resource injection
    @Resource(name="jdbc/web_student_tracker")
    private DataSource dataSource;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// set up the print writer
		PrintWriter outPrintWriter = response.getWriter();
		
		// set content type
		response.setContentType("text/plain");
		
		// getting a connection to the database
		Connection myConnection = null;
		Statement myStatement = null;
		ResultSet myResultSet = null;
		
		try {
			myConnection = dataSource.getConnection();
			
			// create a SQL statement
			String sql = "select * from student";
			myStatement = myConnection.createStatement();
			
			// execute the SQL statement
			myResultSet = myStatement.executeQuery(sql);
			
			// process the result
			while(myResultSet.next()) {
				String email = myResultSet.getString("email");
				outPrintWriter.println(email);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
