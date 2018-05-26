package dao.daoImpl;


import Util.DBUtil;
import dao.CountryDAO;
import model.Country;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CountryDatabaseDAO implements CountryDAO {


    public CountryDatabaseDAO() {
    }
    private DataSource ds;
    @Override
    public boolean create(Country model) {
        String sql = "INSERT INTO country(city_name, country) VALUES (?,?)";
        boolean rowInsert = false;
        try (Connection connection = ds.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, model.getCityName());
            preparedStatement.setString(2, model.getCountry());
            rowInsert = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInsert;
    }

    @Override
    public Country getById(int id) {
        String sql = "SELECT * FROM region WHERE id =?";
        Country country = null;
        try (Connection connection = ds.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                country = getCountryFromDB(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return country;
    }

    @Override
    public List<Country> getAll() {
        List<Country> regionsList = new ArrayList<>();
        String sql = "SELECT * FROM region";
        try (Connection connection = ds.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                regionsList.add(getCountryFromDB(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return regionsList;
    }

    @Override
    public boolean update(Country model) {
        String sql = "UPDATE country SET city_name =?, country =? WHERE id =?";
        boolean rowUpdate = false;
        try (Connection connection = ds.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(3, model.getId());
            preparedStatement.setString(1, model.getCityName());
            preparedStatement.setString(2, model.getCountry());

            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public boolean delete(Country model) {
        String sql = "DELETE FROM region WHERE id=?";
        boolean rowUpdate = false;
        try (Connection connection = ds.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, model.getId());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }
    //util method
    public Country getCountryFromDB(ResultSet rs) throws SQLException {
        return new Country(rs.getInt("id"), rs.getString("city_name"),
                rs.getString("country"));
    }

}
