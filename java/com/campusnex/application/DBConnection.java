package com.campusnex.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	    private static final String URL = "jdbc:mysql://localhost:3306/MajorProject";
	    private static final String USERNAME = "root";
	    private static final String PASSWORD = "Ishamysql@0902";

	   
	    public static Connection getConnection() {
	        Connection connection = null;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	        return connection;
	    }
}

