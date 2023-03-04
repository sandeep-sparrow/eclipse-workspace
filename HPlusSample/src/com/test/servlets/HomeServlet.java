package com.test.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dao.DBConnection;

/**
 * Servlet implementation class Home
 */
@WebServlet( urlPatterns = {"/home", ""})
public class HomeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	public Connection connection = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in doGet method");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/html/index.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	@Override
	public void init() throws ServletException {
		// Initialization activity - set up connection object
		System.out.println("in init method");
		connection = DBConnection.getConnectionToDatabase();
	}
	
	@Override
	public void destroy() {
		// clean up activity
		System.out.println("in destroy method");
		try {
			connection.close();  
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
