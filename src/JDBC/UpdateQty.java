package JDBC;

import java.sql.*;
import java.util.Scanner;

public class UpdateQty {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3307/BookShop";
    static final String USER = "root";
    static final String PASSWORD = "milomilo";
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Update the qty field by given book_id (input from user)
            System.out.print("Enter book_id to update: ");
            int bookIdToUpdate = scanner.nextInt();
            System.out.print("Enter new qty: ");
            int newQty = scanner.nextInt();

            String updateQtySQL = "UPDATE books SET qty = ? WHERE book_id = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateQtySQL);
            updateStmt.setInt(1, newQty);
            updateStmt.setInt(2, bookIdToUpdate);
            int rowsAffected = updateStmt.executeUpdate();

            System.out.println("Updated " + rowsAffected + " record(s)");

            updateStmt.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
