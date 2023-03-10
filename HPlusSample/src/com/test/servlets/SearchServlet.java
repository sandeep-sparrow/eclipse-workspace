package com.test.servlets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.text.MessageFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.beans.Product;
import com.test.dao.ApplicationDao;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// collect search string from the web URL
		String searchString = req.getParameter("search");
		
		req.getSession().setAttribute("search", searchString);
		
		// call DAO Layer
		ApplicationDao applicationDao = new ApplicationDao();
		
		// get the connection from listener servlet
		Connection connection = (Connection) getServletContext().getAttribute("dbConnection");
		
		List<Product> products = applicationDao.searchProducts(searchString, connection);
		
		req.setAttribute("products", products);
		req.getRequestDispatcher("/jsp/searchResult.jsp").forward(req, resp);
		
		//write the product data back to the client
		// String page = getHTMLString(req.getServletContext().getRealPath("html/searchResult.html"), products);
		// resp.getWriter().write(page);
	}
	
	public String getHTMLString(String filePath, List<Product> products) throws IOException {
		
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String line = "";
		StringBuffer buffer = new StringBuffer();
		
		while((line=reader.readLine())!=null){
			buffer.append(line);
		}
		reader.close();
		String page = buffer.toString();
		
		page = MessageFormat.format(page, products.get(0).getProductImgPath(),
				                          products.get(1).getProductImgPath(),
				                          products.get(2).getProductImgPath(),
				                          products.get(0).getProductName(),
				                          products.get(1).getProductName(),
				                          products.get(2).getProductName(),3);
		
		return page;
	}

	
}
