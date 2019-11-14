package project2.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	public static Connection getConnection() {
		String url = "jdbc:postgresql://revature2.chvwilb5xwei.us-east-1.rds.amazonaws.com:5432/postgres";
		try {
			Connection conn = DriverManager.getConnection(
											url,
											System.getenv("AWS_ROLE"),
											System.getenv("AWS_PASS"));
			return conn;
		} catch (SQLException e){
			e.printStackTrace();
			System.out.println("Cannot connect to database.");
			return null;
		}
	}
}
