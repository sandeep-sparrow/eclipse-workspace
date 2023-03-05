package com.test.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getProfileDetails")
public class ViewProfileServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// get the username from the session
		System.out.println("User name in profile sevlet " + req.getSession().getAttribute("username"));
		
		req.setAttribute(getServletName(), resp);
		// forward control to the profile jsp
		req.getRequestDispatcher("/jsp/profile.jsp").forward(req, resp);
	}

	
}
