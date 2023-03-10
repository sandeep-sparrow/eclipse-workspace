package com.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.test.beans.Order;
import com.test.beans.Product;
import com.test.beans.User;

public class ApplicationDao {
	
	public List<Product> searchProducts(String searchString, Connection connection){
		
		Product product = null;
		
		List<Product> products = new ArrayList<>();
		
		try {
			// get the connection
			// Connection connection = DBConnection.getConnectionToDatabase();
						
			// write sql query
			String sql = "select * from products where product_name like '%" + searchString + "%'";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet set = statement.executeQuery(sql);
			
			while(set.next()) {
				product = new Product();
				product.setProductId(set.getInt("product_id"));
				product.setProductImgPath(set.getString("image_path"));
				product.setProductName(set.getString("product_name"));
				products.add(product);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	
	public int registerUser(User user) {
		
		int rowsAffected = 0;
		
		try {
			Connection connection = DBConnection.getConnectionToDatabase();
			
			String insertQuery = "insert into users values(?,?,?,?,?,?)";
			
			PreparedStatement statement = connection.prepareStatement(insertQuery);
			
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFirstName());
			statement.setString(4, user.getLastName());
			statement.setInt(5, user.getAge());
			statement.setString(6, user.getActivity());
			System.out.println(insertQuery);
			
		    rowsAffected = statement.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowsAffected;
	}

	public boolean validateUser(String username, String password) {
		
		boolean isValidUser = false;
		try{
			Connection connection = DBConnection.getConnectionToDatabase();
			
			String sql = "select * from users where username=? and password=?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, username);
			statement.setString(2, password);
			
			ResultSet set = statement.executeQuery();
			
			while(set.next()) {
				isValidUser = true;
			}
			
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		return isValidUser;
		
	}
	
	public User getProfileDetails(String userName) {
		User user = null;
		try {
			Connection connection = DBConnection.getConnectionToDatabase();
			
			String sql = "select * from users where username=?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userName);
			
			ResultSet set = statement.executeQuery();
			while(set.next()) {
				user = new User();
				user.setUsername(set.getString("username"));
				user.setFirstName(set.getString("first_name"));
				user.setLastName(set.getString("last_name"));
				user.setActivity(set.getString("activity"));
				user.setAge(set.getInt("age"));
			}
			
			
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		return user;
	}
	
	public List<Order> getOrders(String username){
		Order order = null;
		List<Order> orders = new ArrayList<>();
		try {
			Connection connection = DBConnection.getConnectionToDatabase();
			
			String sql = "select * from orders where user_name=?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			
			ResultSet set = statement.executeQuery();
			
			while(set.next()) {
				order = new Order();
				order.setOrderId(set.getInt("order_id"));
				order.setProductName(set.getString("product_name"));
				order.setProductImgPath(set.getString("image_path"));
				order.setOrderDate(new Date(set.getDate("order_date").getTime()));
				order.setUsername(set.getString("user_name"));
				orders.add(order);
			}
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		return orders;
	}
}
