package dao;


import model.Order;

import java.util.List;

public interface OrderDAO  {

    public boolean create(int userId);

    public Order getOrderByID(int orderId);

    public List<Order> getAllOrders();

    public List<Order> getOrbderByUser(int userId);

    public boolean deleteOrder( int orderId);
}
