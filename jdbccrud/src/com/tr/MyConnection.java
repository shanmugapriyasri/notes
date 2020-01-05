package com.tr;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyConnection {

	static Connection con;
	
	public static Connection getConnection() {
		//try {
		//	Class.forName("com.mysql.jdbc.Driver");
		//	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","mysql@1234");
		
		try (InputStream input = new FileInputStream("src/connection.properties")) {
            Properties prop = new Properties();
            // load a properties file
            prop.load(input);
            Class.forName(prop.getProperty("driver"));
    		con=DriverManager.getConnection(prop.getProperty("url"),
    				prop.getProperty("username"),prop.getProperty("password"));
	} catch (SQLException | IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static void main(String[] args) {
		System.out.println(MyConnection.getConnection());
	}
}
