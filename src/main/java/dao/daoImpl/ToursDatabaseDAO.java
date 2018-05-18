package dao.daoImpl;


import Util.DBUtil;
import dao.ToursDAO;
import model.Fly;
import model.Hotel;
import model.Region;
import model.Tours;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class ToursDatabaseDAO implements ToursDAO {
    Fly fly;
    Hotel hotel;
    Region region;

    public ToursDatabaseDAO() {
    }

    @Override
    public boolean create(Tours model) {
        String sql = "INSERT INTO tours" +
                "(name," +
                " description," +
                " date_tours," +
                " tours_cost," +
                " hotel_id," +
                " fly_id," +
                " region_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        boolean rowInsert = false;

        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, model.getNameTour());
            preparedStatement.setString(2, model.getDescription());
            preparedStatement.setDate(3, model.getDetaTour());
            preparedStatement.setDouble(4, model.getCostTour());
            preparedStatement.setInt(5, hotel.getId());
            preparedStatement.setInt(6, fly.getId());
            preparedStatement.setInt(7, region.getId());

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
        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            tours.setId(resultSet.getInt("id"));
            tours.setNameTour(resultSet.getString("name"));
            tours.setDescription(resultSet.getString("description"));
            tours.setDetaTour(resultSet.getDate("date_tours"));
            tours.setCostTour(resultSet.getDouble("tours_cost"));
            tours.setHotel_id(resultSet.getInt("hotel_id"));
            tours.setFly_id(resultSet.getInt("fly_id"));
            tours.setRegion_id(resultSet.getInt("region_id"));
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tours;
    }

    @Override
    public Collection<Tours> getAll() {
        Collection<Tours> toursList = new ArrayList<>();
        String sql = "SELECT * FROM tours";
        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Tours tours = new Tours();
                tours.setId(resultSet.getInt("id"));
                tours.setNameTour(resultSet.getString("name"));
                tours.setDescription(resultSet.getString("description"));
                tours.setDetaTour(resultSet.getDate("date_tours"));
                tours.setCostTour(resultSet.getDouble("tours_cost"));
                tours.setHotel_id(resultSet.getInt("hotel_id"));
                tours.setFly_id(resultSet.getInt("fly_id"));
                tours.setRegion_id(resultSet.getInt("region_id"));
                toursList.add(tours);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toursList;
    }

    @Override
    public boolean update(Tours model) {
        String sql = "UPDATE tours SET" +
                " name =?," +
                " description=?," +
                " date_tours= ?," +
                " tours_cost = ?," +
                " hotel_id =?, " +
                "fly_id=?, " +
                "region_id=? " +
                "WHERE id = ?";
        boolean rowUpdate = false;
        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(8, model.getId());
            preparedStatement.setString(1, model.getNameTour());
            preparedStatement.setString(2, model.getDescription());
            preparedStatement.setDate(3, model.getDetaTour());
            preparedStatement.setDouble(4, model.getCostTour());
            preparedStatement.setInt(5, hotel.getId());
            preparedStatement.setInt(6, fly.getId());
            preparedStatement.setInt(7, region.getId());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public boolean delete(Tours model) {
        String sql = "DELETE FROM tours where id = ?";
        boolean rowDelete = false;
        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, model.getId());
            rowDelete = preparedStatement.executeUpdate() > 0;    // помоему тут не верное значение получаем?
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }

    @Override
    public Collection<Tours> getAllbyRegion(int region) {
        Collection<Tours> toursListRegion = new ArrayList<>();
        String sql = "SELECT * FROM tours WHERE region_id = ?";
        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, region);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Tours tours = new Tours();
                tours.setId(resultSet.getInt("id"));
                tours.setNameTour(resultSet.getString("name"));
                tours.setDescription(resultSet.getString("description"));
                tours.setDetaTour(resultSet.getDate("date_tours"));
                tours.setCostTour(resultSet.getDouble("tours_cost"));
                tours.setHotel_id(resultSet.getInt("hotel_id"));
                tours.setFly_id(resultSet.getInt("fly_id"));
                tours.setRegion_id(resultSet.getInt("region_id"));
                toursListRegion.add(tours);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toursListRegion;
    }

}
