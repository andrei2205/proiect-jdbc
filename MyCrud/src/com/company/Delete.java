package com.company;

import java.sql.*;

public class Delete {

	public static void main(String[] args) {
		String dbURL = "jdbc:mysql://localhost:3306/onlinestoredb";
		String username = "root";
		String password = "";
		
		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
			
			String sql = "DELETE FROM users WHERE username=?";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "alibec");
			
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("A user was deleted successfully!");
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}		
	}
}