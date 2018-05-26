package com.devchal.databaseutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class DatabaseUtil {

	final static Logger logger = Logger.getLogger(DatabaseUtil.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		logger.info("------------> TESTING DATABASE CONNECTIONS <------------------");
		testConnection();

	}

	
	public static Connection getConnection(){
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/customerdatabase?" + "user=app_service&password=password");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	public static void testConnection() {
		logger.info("-------------- TEST CONNECTION --------------");

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			try {
				Connection conn = DriverManager.getConnection(
						"jdbc:mysql://localhost/customerdatabase?" + "user=app_service&password=password");

				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * from animals");

				while (rs.next()) {

					String s = rs.getString("name");
					logger.info("ANIMAL TYPE IS  " + s);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// method to read from database
	public static String readDB(String readString) {
		logger.info("---------------- READING DATABASE -----------------");
		String result = null;

		return result;
	}

	// method to write to database
	public static String writeDB(String writeString) {
		logger.info("---------------- WRITING TO DATABASE -----------------");
		String result = null;

		return result;
	}

	// method to write to database
	public static String updateDB(String updateString) {
		logger.info("---------------- UPDATING DATABASE -----------------");
		String result = null;

		return result;
	}

	// method to write to database
	public static String deleteDB(String deleteString) {
		logger.info("---------------- DELETE DATABASE -----------------");
		String result = null;
     
		
		
		return result;
	}
	
	public static String verifyUser(String checkString){
		String result = null;
		
		
		
		return result;
	}
}
