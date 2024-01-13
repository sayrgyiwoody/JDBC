package JDBC;

import java.sql.*;

public class InsertBooks {
	 	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	    static final String DB_URL = "jdbc:mysql://localhost:3307/BookShop";
	    static final String USER = "root";
	    static final String PASSWORD = "milomilo";

	    public static void main(String[] args) {
	        try {
	            Class.forName(JDBC_DRIVER);
	            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

	            // Insert data into "books" table
	            String insertDataSQL = "INSERT INTO books (book_id, title, author, price, qty) VALUES (?, ?, ?, ?, ?)";
	            PreparedStatement pstmt = conn.prepareStatement(insertDataSQL);

	            pstmt.setInt(1, 1001);
	            pstmt.setString(2, "Java for dummies");
	            pstmt.setString(3, "Tan Ah Teck");
	            pstmt.setFloat(4, 100.50f);
	            pstmt.setInt(5, 10);
	            pstmt.executeUpdate();

	            pstmt.setInt(1, 1002);
	            pstmt.setString(2, "More Java for dummies");
	            pstmt.setString(3, "Tan Ah Teck");
	            pstmt.setFloat(4, 110.00f);
	            pstmt.setInt(5, 5);
	            pstmt.executeUpdate();

	            System.out.println("Data inserted successfully!");

	            pstmt.close();
	            conn.close();

	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
