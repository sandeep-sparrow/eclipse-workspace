package com.test.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.beans.Product;
import com.test.dao.ApplicationDao;

@WebServlet("/addProducts")
public class ProductServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Demo of Session management using HttpSession API");
		
		// get the HttpSession Object
		System.out.println("creating session object");
		HttpSession session = req.getSession();
		
		// Create a cart as arrayList for the user
		System.out.println("getting cart list");
		@SuppressWarnings("unchecked")
		List<String> cartList = (ArrayList<String>) session.getAttribute("cart");
		
		if(cartList == null) {
			System.out.println("creating cartList first time");
			cartList = new ArrayList<>();
		}
		
		// add the selected product to the cart
		if(req.getParameter("product")!=null) {
			System.out.println("Adding product name string to cartList");
			cartList.add(req.getParameter("product"));
		}
		
		// set the list to the session object
		System.out.println("setting the cartList String array to \"cart\" object");
		session.setAttribute("cart", cartList);
		
		// get search criteria from search servlet
		System.out.println("using the session object from searchServlet to get search String");
		String search = (String) session.getAttribute("search");
		
		// get the search Result 
		System.out.println("getting all products by using Application dao");
		ApplicationDao dao = new ApplicationDao();
		
		Connection connection = (Connection) getServletContext().getAttribute("dbConnection");
		
		List<Product> products = dao.searchProducts(search, connection);
		
		// set the search result in request scope
		System.out.println("Setting all the products from dao to \"products\" object");
		req.setAttribute("products", products);
		
		// forward to searchResult.jsp
		System.out.println("dispatch products and cart object to jsp page");
		req.getRequestDispatcher("/jsp/searchResult.jsp").forward(req, resp);
	}

	
}
