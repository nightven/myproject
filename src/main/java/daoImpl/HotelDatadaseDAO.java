package daoImpl;


import Util.DBUtil;
import dao.HotelDAO;
import model.Hotel;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;


public class HotelDatadaseDAO  implements HotelDAO {


    public HotelDatadaseDAO() {
    }

    @Override
    public boolean create(Hotel model) {
        String sql = "INSERT  INTO hotel(hotel_name, hotel_star, hotel_date) VALUES (?,?,?)";
        boolean rowInsert = false;
        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, model.getHotelName());
            preparedStatement.setInt(2, model.getHotelStar());
            preparedStatement.setDate(3, model.getDate());

            rowInsert = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInsert;
    }

    @Override
    public Hotel getById(int id) {
        String sql = "SELECT * FROM hotel WHERE hotel_id =?";
        Hotel hotel = new Hotel();
        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            hotel.setId(resultSet.getInt("hotel_id"));
            hotel.setHotelName(resultSet.getString("hotel_name"));
            hotel.setHotelStar(resultSet.getInt("hotel_star"));
            hotel.setDate(resultSet.getDate("hotel_date"));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotel;
    }

    @Override
    public Collection<Hotel> getAll() {
        Collection<Hotel> hotelList = new ArrayList<>();
        String sql = "SELECT * FROM hotel";
        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Hotel hotel = new Hotel();
                hotel.setId(resultSet.getInt(1)); //hotel_id
                hotel.setHotelName(resultSet.getString(2)); //hotel_name
                hotel.setHotelStar(resultSet.getInt(3));//hotel_star
                hotel.setDate(resultSet.getDate(4)); //hotel_date

                hotelList.add(hotel);
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
                " hotel_star=?," +
                " hotel_date=? " +
                "WHERE hotel_id = ?";
        boolean rowUpdate = false;
        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(4,model.getId());
            preparedStatement.setString(1, model.getHotelName());
            preparedStatement.setInt(2, model.getHotelStar());
            preparedStatement.setDate(3, model.getDate());

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

}
