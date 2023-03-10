package com.test.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.beans.Order;
import com.test.dao.ApplicationDao;

@WebServlet("/orderHistory")
public class OrderHistory extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = (String) req.getSession().getAttribute("username");
		
		ApplicationDao dao = new ApplicationDao();
		List<Order> orders = dao.getOrders(username);
		
		req.setAttribute("orders", orders);
		
		req.getRequestDispatcher("/jsp/home.jsp").forward(req, resp);
		
	}
	
	

}
