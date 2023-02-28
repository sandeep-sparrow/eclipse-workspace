package com.test.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * urlPatterns = "/getServlet",
 *			initParams = @WebInitParam(name="URL",value="https://www.youtube.com/"
 * */
@WebServlet
public class GetServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletConfig config = getServletConfig();
		
		System.out.println(config.getInitParameter("URL"));
		
		ServletContext context = getServletContext();
		
		System.out.println(context.getInitParameter("dbURL"));
		
		String value = req.getParameter("name");
		
		String httpResponse = "<html><h3>Welcome to Servlets!</h3></html>";
		
		PrintWriter writer = resp.getWriter();
		
		if(value==null) {
			writer.write(httpResponse);
		}else {
			writer.write(httpResponse + " " + value);
		}
		
		// scopes in web API
		
		
	}
	
	

	
}
