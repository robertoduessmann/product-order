package org.ufpr.sistemapedidos.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			Properties prop = new Properties();
			prop.load(getClass().getResourceAsStream("/resources/db.properties"));
			String dbUrl = prop.getProperty("db.url");
			String dbUser = prop.getProperty("db.user");
			String dbPwd = prop.getProperty("db.pwd");

			return DriverManager.getConnection(dbUrl, dbUser, dbPwd);
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
	}
}