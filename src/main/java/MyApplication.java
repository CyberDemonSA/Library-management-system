import models.User;

import java.sql.*;
import java.util.ArrayList;

public class MyApplication {
    public static void main(String[] args) {
        String connectionString = "jdbc:postgresql://localhost:5432/Library";
        ArrayList<User> books = new ArrayList<>();
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionString, "postgres", "Ilovebil");

            String sql = "SELECT * FROM books ORDER BY id;";
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author= rs.getString("author");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                User user = new User(id, title, author,quantity,price );
                books.add(user);
            }
        } catch (SQLException e) {
            System.out.println("connection error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("driver error: " + e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println("could not close the connection: " + e.getMessage());
                }
            }
        }

        for (User user : books) {
            System.out.println(user);
        }
    }
}
