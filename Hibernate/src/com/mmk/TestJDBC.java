package com.mmk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String un = "hbstudent";
		String pw = "hbstudent";

		try {
			Connection conn = DriverManager.getConnection(jdbcUrl, un, pw);	
			System.out.println("Connection Successful!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
