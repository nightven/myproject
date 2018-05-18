package dao.daoImpl;


import Util.DBUtil;
import dao.HotelDAO;
import model.Hotel;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class HotelDatabaseDAO implements HotelDAO {


    public HotelDatabaseDAO() {
    }

    @Override
    public boolean create(Hotel model) {
        String sql = "INSERT  INTO hotel(" +
                "hotel_name," +
                " hotel_adress," +
                " praice," +
                " date_occupancy," +
                " date_eviction, " +
                "nights, " +
                " country_city_name)" +
                " VALUES (?,?,?,?,?,?,?)";
        boolean rowInsert = false;
        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, model.getHotelName());
            preparedStatement.setString(2, model.getHoteladress());
            preparedStatement.setDouble(3, model.getPrice());
            preparedStatement.setDate(4,model.getDateOcupancy());
            preparedStatement.setDate(5, model.getDateEviction());
            preparedStatement.setInt(6,model.getNights());
            preparedStatement.setString(7, model.getCountryCityName());

            rowInsert = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInsert;
    }

    @Override
    public Hotel getById(int id) {
        String sql = "SELECT * FROM hotel WHERE hotel_id =?";
        Hotel hotel = null;
        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                hotel = getHotelFromDb(resultSet);
            }

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotel;
    }

    @Override
    public List<Hotel> getAll() {
        List<Hotel> hotelList = new ArrayList<>();
        String sql = "SELECT * FROM hotel";
        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                hotelList.add(getHotelFromDb(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotelList;
    }

    @Override
    public boolean update(Hotel model) {
        String sql = "UPDATE hotel SET " +
                "hotel_name=?," +
                "hotel_adress=?," +
                "praice=?," +
                " date_occupancy =?," +
                " date_eviction= ?," +
                " nights=?," +
                " country_city_name = ? " +
                "WHERE hotel_id = ?";
        boolean rowUpdate = false;
        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(8, model.getId());
            preparedStatement.setString(1, model.getHotelName());
            preparedStatement.setString(2, model.getHoteladress());
            preparedStatement.setDouble(3, model.getPrice());
            preparedStatement.setDate(4, model.getDateOcupancy());
            preparedStatement.setDate(5, model.getDateEviction());
            preparedStatement.setInt(6, model.getNights());
            preparedStatement.setString(7, model.getCountryCityName());

            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowUpdate;
    }

    @Override
    public boolean delete(Hotel model) {
        String sql = "DELETE FROM hotel WHERE fly_id =?";
        boolean rowDelete = false;
        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, model.getId());

            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }

    @Override
    public List<Hotel> getHotelByOrderID(int orderId) {       //тут не верная выборка
        List<Hotel> hotelsList = new ArrayList<>();
        String sql= "SELECT h.hotel_id, h.hotel_name, h.hotel_adress, h.country_id, h.country_city_name" +
                " FROM order o JOIN hotel h ON o.id= h.hotel_id where o.id =?";
        try(Connection connection = DBUtil.getDataSource().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, orderId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotelsList;
    }

        //Util method
    private static Hotel getHotelFromDb(ResultSet rs) throws SQLException {
        return new Hotel(rs.getInt("hotel_id"), rs.getString("hotel_name"),
                rs.getString("hotel_adress"),rs.getDouble("price"),
                rs.getDate("date_occupancy"), rs.getDate("hotel_eviction"),
                rs.getInt("nights"), rs.getString("country_city_name"));
    }


}
