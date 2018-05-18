package dao;


import model.Order;

import java.util.List;

public interface OrderDAO extends ItemDAO<Order> {

    public List<Order> getOrbderByUser(int userId);
}
