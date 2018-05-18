package dao.daoImpl;


import Util.DBUtil;
import dao.RegionDAO;
import model.Region;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class RegionDatabaseDAO implements RegionDAO {


    public RegionDatabaseDAO() {
    }

    @Override
    public boolean create(Region model) {
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
    public Region getById(int id) {
        String sql = "SELECT * FROM region WHERE id =?";
        Region region = new Region();
        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            region.setId(resultSet.getInt("id"));
            region.setRegion(resultSet.getString("region"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return region;
    }

    @Override
    public Collection<Region> getAll() {
        Collection<Region> regionsList = new ArrayList<>();
        String sql = "SELECT * FROM region";
        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Region region = new Region();
                region.setId(resultSet.getInt("id"));
                region.setRegion(resultSet.getString("region"));
                regionsList.add(region);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return regionsList;
    }

    @Override
    public boolean update(Region model) {
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
    public boolean delete(Region model) {
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
