package com.luv2code.web.jdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDbUtil {
	
	private DataSource dataSource;
	
	public StudentDbUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Student> getStudents() throws Exception {
		
		List<Student> students = new ArrayList<>();
		
		Connection myConnection = null;
		Statement myStatement = null;
		ResultSet myResultSet = null;
		
		try {
			// get the connection
			myConnection = dataSource.getConnection();
			
			// create SQL statement
			String sql = "select * from student order by last_name";
			
			myStatement = myConnection.createStatement();
			
			// execute the statement
			myResultSet = myStatement.executeQuery(sql);
			
			// process the result set
			while(myResultSet.next()) {
				// retrieve data from result set row
				int id = myResultSet.getInt("id");
				String firstName = myResultSet.getString("first_name");
				String lastName = myResultSet.getString("last_name");
				String email = myResultSet.getString("email");
				
				// create student object
				Student tempStudent = new Student(id, firstName, lastName, email);
				
				// add it to the list of students
				students.add(tempStudent);
			}
			
			return students;
			
		}finally {
			
			// close JDBC objects
			Close(myConnection, myStatement, myResultSet);
			
		}
	}

	private void Close(Connection myConnection, Statement myStatement, ResultSet myResultSet) {
		try {
			
			if(myResultSet != null) {
				myResultSet.close();
			}
			
			if(myStatement != null) {
				myStatement.close();
			}
			
			if(myConnection != null) {
				myConnection.close(); // don't really close, just put the connection back to pool
			}
			
		}catch (Exception exc) {
			
			exc.printStackTrace();
			
		}
		
	}
}
