package com.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.beans.Product;
import com.test.beans.User;

public class ApplicationDao {
	
	public List<Product> searchProducts(String searchString){
		
		Product product = null;
		
		List<Product> products = new ArrayList<>();
		
		try {
			// get the connection
			Connection connection = DBConnection.getConnectionToDatabase();
			
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
}
