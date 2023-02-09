package com.luv2code.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyGenericServlet extends GenericServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		System.out.println("Generic Service via Extend.....");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
        out.print("<h3>This is my output from my servlet method: com.luv2code.jsp.servlet.MyGenericSerlvet</h3>");
        out.print("<h4>Today's date and time: " + new Date().toString() + "</h4>");
		
	}

}
