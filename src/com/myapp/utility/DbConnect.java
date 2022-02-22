package com.myapp.utility;

import java.sql.*;
import java.util.*;
import java.io.*;

public class DbConnect {
	// establish the database connection
	private static Connection con = null;

	public static Connection getConnection() {
		try {

		} catch (Exception e) {
			System.out.println(e);
		}
		if (con != null)
			return con;
		else {
			try {
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "password");
				System.out.println("We are connected tothe db");
				con.setAutoCommit(false);
				System.out.println("We are connected tothe db");
			}catch (SQLException e) {
				System.out.println("problem in connecting db");
			}
			return con;
		}
	}

	// create a method to close the connection
	public void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
