package com.company;

import java.sql.*;

public class Update {

	public static void main(String[] args) {
		String dbURL = "jdbc:mysql://localhost:3306/onlinestoredb";
		String username = "root";
		String password = "";

		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

			String sql = "UPDATE users SET password=?, fullname=?, email=? WHERE username=?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "tanase");
			statement.setString(2, "Florin Tanase");
			statement.setString(3, "florintanase@fcsb.com");
			statement.setString(4, "alibec");

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("An existing user was updated successfully!");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}