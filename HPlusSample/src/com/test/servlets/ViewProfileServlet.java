package com.test.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.beans.User;
import com.test.dao.ApplicationDao;

@WebServlet("/getProfileDetails")
public class ViewProfileServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// get the username from the session
		System.out.println("User name in profile sevlet " + req.getSession().getAttribute("username"));
		String userName = (String)req.getSession().getAttribute("username");
		
		ApplicationDao dao = new ApplicationDao();
		User user = dao.getProfileDetails(userName);
		
		Map<String, Double> weightSummary = new HashMap<>();
		weightSummary.put("January", 67.9);
		weightSummary.put("February", 65.9);
		weightSummary.put("March", 64.9);
		
		req.setAttribute("user", user);
		req.setAttribute("weightSummary", weightSummary);
		
		req.setAttribute(getServletName(), resp);
		// forward control to the profile jsp
		req.getRequestDispatcher("/jsp/profile.jsp").forward(req, resp);
	}

	
}
