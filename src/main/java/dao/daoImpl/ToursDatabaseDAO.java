package dao.daoImpl;


import Util.DBUtil;
import dao.ToursDAO;

import model.Tours;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ToursDatabaseDAO implements ToursDAO {

    private DataSource ds;


    @Override
    public boolean create(Tours model) {
        String sql = "INSERT INTO tours" +
                "(name,description,start_tour,end_tour,tour_cost)" +
                "VALUES (?, ?, ?, ?, ?)";
        boolean rowInsert = false;

        try (Connection connection = ds.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, model.getNameTour());
            preparedStatement.setString(2, model.getDescription());
            preparedStatement.setDate(3, model.getStartDateTours());
            preparedStatement.setDate(4, model.getEndDateTours());
            preparedStatement.setDouble(5, model.getCostTour());

            rowInsert = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInsert;
    }

    @Override
    public Tours getById(int id) {
        String sql = "SELECT * FROM tours where id =?";
        Tours tours = new Tours();
        try (Connection connection = ds.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                tours = getTourFromDb(resultSet);
            }

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tours;
    }

    @Override
    public List<Tours> getAll() {
        List<Tours> toursList = new ArrayList<>();
        String sql = "SELECT * FROM tours";
        try (Connection connection = ds.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                toursList.add(getTourFromDb(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toursList;
    }

    @Override
    public boolean update(Tours model) {
        String sql = "UPDATE tours SET" +
                " name = ?," +
                " description= ?, " +
                "start_tour =?, " +
                "end_tour = ?, " +
                "tour_cost = ? " +
                "WHERE id =?";
        boolean rowUpdate = false;
        try(Connection connection = ds.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(5, model.getId());
            preparedStatement.setString(1, model.getNameTour());
            preparedStatement.setString(2, model.getDescription());
            preparedStatement.setDate(3, model.getStartDateTours());
            preparedStatement.setDate(4, model.getEndDateTours());

            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public boolean delete(Tours model) {
        String sql = "DELETE FROM tours WHERE id= ?";
        boolean rowDelete = false;
        try(Connection connection = ds.getConnection();
        PreparedStatement preparedStatement= connection.prepareStatement(sql)) {
            preparedStatement .setInt(1, model.getId());
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }



    @Override
    public boolean setOrderTour(int orderId, int toursId) {
        String sql = "INSERT INTO order_has_tours(Order_id, tours_id) VALUES(?, ?)";
        boolean rowSetOrderTour = false;
        try(Connection connection = ds.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1,orderId);
            preparedStatement.setInt(2, toursId);

            rowSetOrderTour = preparedStatement.executeUpdate()> 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowSetOrderTour;
    }

    @Override
    public boolean deleteOrderTours(int orderId) {
        String sql = "DELETE FROM order_has_tours where Order_id =?";
        boolean rowDeletOrderTours = false;
        try(Connection connection = ds.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, orderId);

            rowDeletOrderTours = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeletOrderTours;
    }

    // Utility methods
    private static Tours getTourFromDb(ResultSet rs) throws SQLException {
        return new Tours(rs.getInt("id"), rs.getString("name"), rs.getString("description"),
                rs.getDate("start_tour"), rs.getDate("end_tour"), rs.getDouble("tour.cost"));
    }


}
