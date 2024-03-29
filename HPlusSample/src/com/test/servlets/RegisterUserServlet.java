package com.test.servlets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.beans.User;
import com.test.dao.ApplicationDao;

@WebServlet("/registerUser")
public class RegisterUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = getHTMLString(req.getServletContext().getRealPath("/html/register.html"),"");
		resp.getWriter().write(page);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// collect all the data
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		String firstName = req.getParameter("fname");
		String lastName = req.getParameter("lname");
		String activity = req.getParameter("activity");
		int age = Integer.parseInt(req.getParameter("age"));
		
		// fill it up in a user bean
		User user = new User(userName, password, firstName, lastName, age, activity);
	
		// call DAO layer
		ApplicationDao applicationDao = new ApplicationDao();
		int rows = applicationDao.registerUser(user);
		
		// prepare the information message
		String infoMessage = null;
		if(rows==0) {
			infoMessage = "Sorry, an error occurred";
		}else {
			infoMessage="User was registered succesfully";
		}
		
		String page = getHTMLString(req.getServletContext().getRealPath("html/register.html"), infoMessage);
		resp.getWriter().write(page);
		
	}
	
	public String getHTMLString(String filePath, String message) throws IOException {
		
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String line = "";
		StringBuffer buffer = new StringBuffer();
		
		while((line=reader.readLine())!=null){
			buffer.append(line);
		}
		reader.close();
		String page = buffer.toString();
		
		page = MessageFormat.format(page, message);
		
		return page;
	}



	
	
}
