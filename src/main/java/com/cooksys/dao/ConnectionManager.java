package com.cooksys.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {

	{
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static ResultSet executeQuery(String query) {
		ResultSet results = null;
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/practice", "postgres",
					"bondstone");

			Statement statement = connection.createStatement();

			results = statement.executeQuery(query);

			connection.close();

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return results;
	}

	public static int executeUpdate(String query) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/practice", "postgres",
					"bondstone");

			Statement statement = connection.createStatement();

			int save = statement.executeUpdate(query);

			connection.close();
			return save;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return 0;
	}
}