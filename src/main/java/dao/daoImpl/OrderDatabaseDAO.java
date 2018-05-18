package dao.daoImpl;


import Util.DBUtil;
import dao.OrderDAO;
import model.Order;
import model.Tours;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class OrderDatabaseDAO implements OrderDAO {
    Tours tours;
    User user;

    public OrderDatabaseDAO() {

    }


    @Override
    public boolean create(Order model) {
        String sql = "INSERT INTO  order(user_id, tours_id) VALUES (?,?)";
        boolean rowInsert = false;


        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setInt(2, tours.getId());
            rowInsert = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInsert;

    }

    @Override
    public Order getById(int id) {
        String sql = "SELECT * FROM order WHERE order_id = ?";
        Order order = new Order();
        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            order.setId(resultSet.getInt("order_id"));
            order.setUser_id(resultSet.getInt("user_id"));
            order.setTours_id(resultSet.getInt("tours_id"));
            order.setCreateDate(resultSet.getDate("order_cr_dt"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public Collection<Order> getAll() {
        String sql = "SELECT * FROM 'order'";
        Collection<Order> orderList = new ArrayList<>();
        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("order_id"));
                order.setUser_id(resultSet.getInt("user_id"));
                order.setTours_id(resultSet.getInt("tours_id"));
                order.setCreateDate(resultSet.getDate("order_cr_dt"));
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public boolean update(Order model) {
        String sql = "UPDATE order SET" +
                " user_id = ?," +
                " tours_id= ? " +
                "WHERE order_id = ?";
        boolean rowUpdate = false;
        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(3, model.getId());
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setInt(2, tours.getId());
            rowUpdate = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public boolean delete(Order model) {
        String sql = "DELETE FROM `order` WHERE order_id =?";
        boolean rowUpdate = false;
        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, model.getId());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }


}
