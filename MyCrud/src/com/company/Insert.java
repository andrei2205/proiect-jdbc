package com.company;

import java.sql.*;

public class Insert {

	public static void main(String[] args) {
		String dbURL = "jdbc:mysql://localhost:3306/onlinestoredb";
		String username = "root";
		String password = "";
		
		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
			
			String sql = "INSERT INTO users (username, password, fullname, email) VALUES (?, ?, ?, ?)";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "alibec");
			statement.setString(2, "password");
			statement.setString(3, "Denis Alibec");
			statement.setString(4, "denisalibec@astra.com");
			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new user was inserted successfully!");
			}

			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}		
	}
}