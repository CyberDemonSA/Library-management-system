package repositories;

import data.interfaces.IDB;
import entities.Order;
import repositories.interfaces.IOrderRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class OrderRepository implements IOrderRepository {
    private final IDB db;  // Dependency Injection

    public OrderRepository(IDB db) {
        this.db = db;
    }

    public boolean createOrder(Order order) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "INSERT INTO orders_of_books(user_client_id,book_id,date_of_issue,due_date) VALUES (?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, order.getUsers_id());
            st.setInt(2, order.getBook_id());
            st.setString(3, order.getDate_of_issue());
            st.setString(4, order.getDue_date());

            st.execute();

            return true;
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                System.out.println("sql error: " + e.getMessage());
            }
        }

        return false;
    }

    public Order getOrder(int id) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT order_id,user_client_id,book_id,date_of_issue,due_date FROM orders_of_books WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Order(rs.getInt("order_id"),
                        rs.getInt("user_client_id"),
                        rs.getString("date_of_issue"),
                        rs.getString("due_date"));


            }
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                System.out.println("sql error: " + e.getMessage());
            }
        }

        return null;
    }

    public List<Order> getAllOrders() {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT order_id,user_client_id,book_id,date_of_issue,due_date FROM orders_of_books";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Order> orders = new LinkedList<>();
            while (rs.next()) {
                Order order = new Order(rs.getInt("order_id"),
                        rs.getInt("user_client_id"),
                        rs.getString("date_of_issue"),
                        rs.getString("due_date"));;

                orders.add(order);
            }

            return orders;
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                System.out.println("sql error: " + e.getMessage());
            }
        }

        return null;
    }
}
