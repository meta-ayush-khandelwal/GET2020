package com.employee.databaseConnection;


import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	private static DbConnection single_instance = null;
	private static String url = "jdbc:mysql://localhost:3306/parkingsystem";
	private static String username = "root";
	private static String password = "metacube";
	private static Connection connection = null;
	
	public static DbConnection getInstance(){
		if (single_instance == null) 
			single_instance = new DbConnection(); 
		return single_instance;
	}
	
	public static Connection getConnection(){
		
		try{
			if(connection == null) {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(url,username,password);
			}
		}
		catch(Exception e)	{
			e.printStackTrace();
		}
		return connection;
	}
}
