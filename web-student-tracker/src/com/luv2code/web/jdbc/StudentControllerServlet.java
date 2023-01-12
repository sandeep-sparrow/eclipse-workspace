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
			
		} catch (Exception exc) {
			throw new ServletException(); 
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// list the students ... in MVC Fashion
		
		try {
			listStudents(request, response);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
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
