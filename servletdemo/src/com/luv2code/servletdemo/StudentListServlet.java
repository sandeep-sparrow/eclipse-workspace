package com.luv2code.servletdemo;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luv2code.servletdemo.model.Student;
import com.luv2code.servletdemo.model.StudentDataUtil;

@WebServlet("/StudentListServlet")
public class StudentListServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public StudentListServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get the data from Utility class
		List<Student> students = StudentDataUtil.getStudents();
		
		// add the students data to request object
		request.setAttribute("student_list", students);
		
		// get request dispatcher
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view_students_model.jsp");
		
		// forward to jsp
		requestDispatcher.forward(request, response);
	}


}
