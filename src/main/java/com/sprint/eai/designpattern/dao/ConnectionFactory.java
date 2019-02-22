package com.sprint.eai.designpattern.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.h2.tools.RunScript;

public class ConnectionFactory {
	private static final String URL = "jdbc:h2:mem:publish-subscribe;DB_CLOSE_DELAY=-1";
	private static final String USER = "sa";
	private static final String PASSWD = "";
	private static final String DRIVER = "org.h2.Driver";

	/**
	 * Get h2 db connection.
	 * 
	 * @return
	 */
	public static Connection getConnection() {

		try {
			Class.forName(DRIVER);

			return DriverManager.getConnection(URL, USER, PASSWD);

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error during driver registration - " + e);
			throw new RuntimeException(e);
		}

	}

	/**
	 * Execute sql script to create db and populate testing data.
	 */
	public static void populateTestData() {
		System.out.println("running populateTestData using H2 db in memory");

		try (Connection conn = ConnectionFactory.getConnection()) {

			BufferedReader reader = new BufferedReader(
					new InputStreamReader(ConnectionFactory.class.getResourceAsStream("/schema.sql")));

			RunScript.execute(conn, reader);

		} catch (SQLException e) {

			System.out.println("Error during loading test data - " + e);
			throw new RuntimeException(e);

		}
	}
}
