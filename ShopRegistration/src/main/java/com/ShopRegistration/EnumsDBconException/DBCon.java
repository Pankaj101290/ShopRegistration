package com.ShopRegistration.EnumsDBconException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBCon {

	public DBCon() {
	}

	public static Connection connectDB() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Properties p = new Properties();
		File f = new File("C:\\Users\\Dell\\eclipse-workspace\\ShopRegistration\\app.properties");
		Connection c = null;
		try {
			FileInputStream fis = new FileInputStream(f);
			p.load(fis);

			String url = p.getProperty("url");
			String username = p.getProperty("username");
			String password = p.getProperty("password");
			c = DriverManager.getConnection(url, username, password);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return c;
	}
}
