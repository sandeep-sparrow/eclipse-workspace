package com.luv2code.jsp.servlet;

import java.io.IOException;

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
