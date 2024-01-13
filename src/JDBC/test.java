package JDBC;

import java.sql.*;

public class test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Step 1
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/userdb", "root", "milomilo"); // Step 2
        Statement stmt = con.createStatement(); // Step 3
        ResultSet rs = stmt.executeQuery("select * from users"); // Step 4
        while (rs.next()) {
            int u_id = rs.getInt("id");
            String u_email = rs.getString("email");
            String u_fullname = rs.getString("fullname");
            System.out.println(u_id + "\t" + u_email + "\t" + u_fullname);
        }
        stmt.close(); // Step 5
        con.close(); // Step 6
    }
}
