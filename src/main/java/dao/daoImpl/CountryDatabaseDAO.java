package dao.daoImpl;


import Util.DBUtil;
import dao.CountryDAO;
import model.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class CountryDatabaseDAO implements CountryDAO {


    public CountryDatabaseDAO() {
    }

    @Override
    public boolean create(Country model) {
        String sql = "INSERT INTO region(region) VALUES (?)";
        boolean rowInsert = false;
        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, model.getRegion());
            rowInsert = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInsert;
    }

    @Override
    public Country getById(int id) {
        String sql = "SELECT * FROM region WHERE id =?";
        Country Country = new Country();
        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            Country.setId(resultSet.getInt("id"));
            Country.setRegion(resultSet.getString("Country"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Country;
    }

    @Override
    public Collection<Country> getAll() {
        Collection<Country> regionsList = new ArrayList<>();
        String sql = "SELECT * FROM region";
        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Country Country = new Country();
                Country.setId(resultSet.getInt("id"));
                Country.setRegion(resultSet.getString("Country"));
                regionsList.add(Country);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return regionsList;
    }

    @Override
    public boolean update(Country model) {
        String sql = "UPDATE region SET region =? WHERE id =?";
        boolean rowUpdate = false;
        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(2, model.getId());
            preparedStatement.setString(1, model.getRegion());
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
