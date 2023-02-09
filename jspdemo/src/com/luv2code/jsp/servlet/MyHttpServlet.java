package com.luv2code.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyHttpServlet extends HttpServlet{


	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws 	ServletException, IOException{
		
		System.out.println("This is get Method.....");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("<h4>This is Get Method of my HTTP Servlet</h4>");
		
	}
	

}
