package com.luv2code.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyServlet implements Servlet {

    ServletConfig confg;

    // life cycle method
	@Override
	public void init(ServletConfig confg) throws ServletException {
        this.confg = confg;
		System.out.println("Creating Object....");
		
	}

    // life cycle method
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// logic processing
        System.out.println("Servicing......");
        // set the content type of ther response
        arg1.setContentType("text/html");
        PrintWriter out =  arg1.getWriter();
        out.print("<h3>This is my output from my servlet method: com.luv2code.jsp.servlet.MySerlvet</h3>");
        out.print("<h4>Today's date and time: " + new Date().toString() + "</h4>");
		
	}
    // life cycle method
	@Override
	public void destroy() {

        System.out.println("Destroying.....");
		
	}

    // non life cycle methods...
	@Override
	public ServletConfig getServletConfig() {
		
		return this.confg;
	}

	@Override
	public String getServletInfo() {
		
		return "This Servlet is created by Sandeep Prajapati";
	}
}
