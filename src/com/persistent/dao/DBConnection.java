package com.persistent.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class DBConnection {
 	public static Connection getConnection() throws Exception {
 		Properties prop = new Properties();
 		InputStream input = null;
 		input = DBConnection.class.getResourceAsStream("config.properties");
		prop.load(input);

 		Class.forName("com.mysql.jdbc.Driver");
 		Connection con = DriverManager.getConnection( prop.getProperty("url"),prop.getProperty("uname"),prop.getProperty("pwd"));
 		return con;
 	}
// 	
// 	public static void main(String as[]) throws Exception {
// 	System.out.println("Indside");
// 	System.out.println(getConnection());
// 	}
}
