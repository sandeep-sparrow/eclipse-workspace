package com.test.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.dao.ApplicationDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String html = "<html><h3>Please login</h3></html>";
		resp.getWriter().write(html + " ");
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/login.jsp");
		requestDispatcher.include(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// get the username for the login here
		String username = req.getParameter("username");
		String password = req.getParameter("password");
	
		System.out.println(username);
		System.out.println(password);
		
		// call the DAO class for validation logic
		ApplicationDao dao = new ApplicationDao();
		boolean isUserValid = dao.validateUser(username, password);
		
		// check if user is invalid setup up an error message
		if(isUserValid) {
			// setup the HTTP session
			HttpSession session = req.getSession();
			
			// set the username as an attribute
			session.setAttribute("username", username);
			
			// forward to the home page
			req.getRequestDispatcher("/jsp/home.jsp").forward(req, resp);
		}else {
			String errorMessage = "Invalid Credentials, please login again!";
			req.setAttribute("error", errorMessage);
			req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
		}

		

		

	}
	
	

}
