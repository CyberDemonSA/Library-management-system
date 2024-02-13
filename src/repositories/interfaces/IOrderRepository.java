package repositories.interfaces;

import entities.Order;

import java.util.List;

public interface IOrderRepository {
    boolean createOrder(Order order);
    public Order getOrder(int id);
    public List<Order> getAllOrders();
}