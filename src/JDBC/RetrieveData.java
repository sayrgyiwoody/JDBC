package JDBC;

import java.sql.*;

public class RetrieveData {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3307/BookShop";
    static final String USER = "root";
    static final String PASSWORD = "milomilo";
    
    public static void main(String[] args) {
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Retrieve all records from "books" table
            String retrieveDataSQL = "SELECT * FROM books";
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(retrieveDataSQL);

            while (resultSet.next()) {
                int bookId = resultSet.getInt("book_id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                float price = resultSet.getFloat("price");
                int qty = resultSet.getInt("qty");

                System.out.println("Book ID: " + bookId + ", Title: " + title +
                        ", Author: " + author + ", Price: " + price + ", Qty: " + qty);
            }

            stmt.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
