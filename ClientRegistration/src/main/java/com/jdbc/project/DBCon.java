package com.jdbc.project;

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
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		String url = "jdbc:mysql://localhost:3306/mydb";
//		String username = "root";
//		String password = "root";
//
//		Connection c = DriverManager.getConnection(url, username, password);
//		return c;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Properties p = new Properties();
		File f = new File("C:\\Users\\Dell\\eclipse-workspace\\JDBC\\src\\com\\jdbc\\project\\app.properties");
		Connection c = null;
		try {
			FileInputStream fis = new FileInputStream(f);
			p.load(fis);

			String url = p.getProperty("url");
		//	System.out.println(url);
			String username = p.getProperty("username");
		//	System.out.println(username);
			String password = p.getProperty("password");
		//	System.out.println(password);

			c = DriverManager.getConnection(url, username, password);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return c;
	}
}
