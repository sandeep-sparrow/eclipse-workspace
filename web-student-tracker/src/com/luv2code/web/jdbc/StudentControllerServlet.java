package com.luv2code.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private StudentDbUtil studentDbUtil;
	
	@Resource(name="jdbc/web_student_tracker")
	private DataSource dataSource;
	
	
	@Override
	public void init() throws ServletException {
		
		super.init();
		
		// create instance student DB utility and pass in the connection pool / data Source
		try {
			studentDbUtil = new StudentDbUtil(dataSource);
		} 
		catch (Exception exc) {
			throw new ServletException(); 
		}
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// read the command parameter
			String theCommand = request.getParameter("command");
			
			// if the command is blank or empty do the default list the students
			if(theCommand == null) {
				theCommand = "LIST";
			}
			// route the appropriate method - routing logic
			switch (theCommand) {
			case "LIST": 
				listStudents(request, response);
				break;
				
			case "ADD":
				addStudent(request, response);
				break;
				
			default:
				listStudents(request, response);
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// read student info from form data
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		// create a new student object
		Student theStudent = new Student(firstName, lastName, email);
		
		// add the student to the database
		studentDbUtil.addStudent(theStudent);
		
		// send back the main page ( get list of student again)
		listStudents(request, response);
		
	}

	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// get students from DB utility
		List<Student> students = studentDbUtil.getStudents();
		
		// add student to that request object
		request.setAttribute("STUDENT_LIST", students);
		
		// send the JSP page
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/list-students.jsp");
		
		// forward to JSP
		requestDispatcher.forward(request, response);
		
	}

}
