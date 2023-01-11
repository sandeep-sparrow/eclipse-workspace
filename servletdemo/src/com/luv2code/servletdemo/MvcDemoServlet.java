package com.luv2code.servletdemo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MvcDemoServlet")
public class MvcDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MvcDemoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// step0: Add data
		String[] students = {"Pujan","Dhairya","Prachi"};
		request.setAttribute("student_list", students);
		
		// step1: get request dispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view_students.jsp");
		
		// step2: forward the request to JSP
		dispatcher.forward(request, response);
		
		
	}


}
