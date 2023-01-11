package com.luv2code.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ StudentServlet")
public class StudentSerlvet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// step1: set content type
		resp.setContentType("text/html");
		
		// step2: get the printwriter
		PrintWriter out = resp.getWriter();
		
		// step3: generate the HTML content
		out.println("<html><body>");
		
		out.println("<h2>Hello World</h2>");
		
		out.println("<hr>");
		
		out.println("The Student is Confirmed: "
				+ req.getParameter("firstName") 
				+ " "
				+ req.getParameter("lastName"));
		
		out.println("</body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	

}
