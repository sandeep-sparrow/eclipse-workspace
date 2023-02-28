package com.test.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// String html = "<html><h3>Please login</h3></html>";
		// resp.getWriter().write(html);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("html/login.jsp");
		requestDispatcher.include(req, resp);
	}

}
