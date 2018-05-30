package dao.daoImpl;


import Util.DBUtil;
import dao.OrderDAO;
import model.Order;

import javax.sql.DataSource;
import java.lang.ref.PhantomReference;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDatabaseDAO implements OrderDAO {
    public OrderDatabaseDAO() {

    }
    private DataSource ds;

    @Override
    public boolean create(int userId) {
        String sql = "INSERT INTO `order`( user_id) values (?)";
        boolean rowCreate = false;
        int lastId = 0;
        try(Connection connection = ds.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, userId);
           rowCreate = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowCreate;
    }

    @Override
    public Order getOrderByID(int orderId) {
        String sql = "SELECT o.id, u.user_id, u.email AS user_email, t.id AS tour_id, t.name AS tour_name, t.tour_cost AS tour_price,\n" +
                "  h.hotel_id, h.price AS hotel_price, f.fly_id, f.price AS fly_price\n" +
                "FROM `order` o JOIN user u on o.user_id = u.user_id \n" +
                "LEFT JOIN order_has_tours ot ON o.id = ot.Order_id\n" +
                "LEFT JOIN tours t on t.id = ot.tours_id\n" +
                "LEFT JOIN fly_has_order fo on o.id = fo.Order_id\n" +
                "LEFT JOIN fly f on f.fly_id = fo.fly_id\n" +
                "LEFT JOIN hotel_has_order ho on o.id = ho.Order_id\n" +
                "LEFT JOIN hotel h ON h.hotel_id =ho.hotel_hotel_id\n" +
                "WHERE o.id =?\n" +
                "GROUP BY o.id";
        Order order = null;
        try(Connection connection = ds.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
                order.setId(resultSet.getInt("id"));
                order.setUserId(resultSet.getInt("user_id"));
                order.setUserMail(resultSet.getString("user_email"));
                order.setTourId(resultSet.getInt("tour_id"));
                order.setTourName(resultSet.getString("tour_name"));
                order.setTourCost(resultSet.getDouble("tour_price"));
                order.setHotelId(resultSet.getInt("hotel_id"));
                order.setHotelPrice(resultSet.getDouble("hotel_prise"));
                order.setFlyId(resultSet.getInt("fly_id"));
                order.setFlyprice(resultSet.getDouble("fly_price"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order>orderList = new ArrayList<>();
        String sql = "SELECT o.id, u.user_id, email AS user_mail, t.id AS tour_id, t.name AS tour_name, t.tour_cost AS tour_price, h.hotel_id, h.price AS hotel_price, f.fly_id, f.price AS fly_price\n" +
                "FROM `order`o JOIN user u on o.user_id = u.user_id\n" +
                "LEFT JOIN order_has_tours ot ON o.id = ot.Order_id\n" +
                "LEFT JOIN tours t ON ot.tours_id = t.id\n" +
                "LEFT JOIN hotel_has_order ho ON o.id = ho.Order_id\n" +
                "LEFT JOIN hotel h ON ho.hotel_hotel_id = h.hotel_id\n" +
                "LEFT JOIN fly_has_order fo on o.id = fo.Order_id\n" +
                "LEFT JOIN fly f ON fo.fly_id = f.fly_id\n" +
                "GROUP BY o.id";
        try(Connection connection =ds.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setUserId(resultSet.getInt("user_id"));
                order.setUserMail(resultSet.getString("user_email"));
                order.setTourId(resultSet.getInt("tour_id"));
                order.setTourName(resultSet.getString("tour_name"));
                order.setTourCost(resultSet.getDouble("tour_price"));
                order.setHotelId(resultSet.getInt("hotel_id"));
                order.setHotelPrice(resultSet.getDouble("hotel_prise"));
                order.setFlyId(resultSet.getInt("fly_id"));
                order.setFlyprice(resultSet.getDouble("fly_price"));
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Order> getOrbderByUser(int userId) {
        List<Order>orderList = new ArrayList<>();
        String sql = "SELECT o.id, u.user_id, u.email AS user_email, t.id AS tour_id, t.name AS tour_name, t.tour_cost AS tour_price,\n" +
                "  h.hotel_id, h.price AS hotel_price, f.fly_id, f.price AS fly_price\n" +
                "FROM `order` o JOIN user u on o.user_id = u.user_id \n" +
                "LEFT JOIN order_has_tours ot ON o.id = ot.Order_id\n" +
                "LEFT JOIN tours t on t.id = ot.tours_id\n" +
                "LEFT JOIN fly_has_order fo on o.id = fo.Order_id\n" +
                "LEFT JOIN fly f on f.fly_id = fo.fly_id\n" +
                "LEFT JOIN hotel_has_order ho on o.id = ho.Order_id\n" +
                "LEFT JOIN hotel h ON h.hotel_id =ho.hotel_hotel_id\n" +
                "WHERE o.user_id =?\n" +
                "GROUP BY o.id";
            try(Connection connection = ds.getConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(sql)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Order order = new Order();
                    order.setId(resultSet.getInt("id"));
                    order.setUserId(resultSet.getInt("user_id"));
                    order.setUserMail(resultSet.getString("user_email"));
                    order.setTourId(resultSet.getInt("tour_id"));
                    order.setTourName(resultSet.getString("tour_name"));
                    order.setTourCost(resultSet.getDouble("tour_price"));
                    order.setHotelId(resultSet.getInt("hotel_id"));
                    order.setHotelPrice(resultSet.getDouble("hotel_prise"));
                    order.setFlyId(resultSet.getInt("fly_id"));
                    order.setFlyprice(resultSet.getDouble("fly_price"));
                    orderList.add(order);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return orderList;
    }

    @Override
    public boolean deleteOrder(int orderId) {
        String sql ="DELETE FROM `order` WHERE id =?";
        boolean rowDeleteOrder = false;
        try(Connection connection = ds.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, orderId);

            rowDeleteOrder = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleteOrder;
    }

}
