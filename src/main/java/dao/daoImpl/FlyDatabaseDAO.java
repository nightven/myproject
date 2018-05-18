package dao.daoImpl;


import Util.DBUtil;
import dao.FlyDAO;
import model.Fly;


import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class FlyDatabaseDAO implements FlyDAO {


    public FlyDatabaseDAO() {

    }


    public boolean create(Fly model) {
        String sql = "INSERT  INTO fly(air_company, fly_date) VALUES (?, ?)";
        boolean rowInsert = false;
        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, model.getAir_company());
            preparedStatement.setDate(2, model.getDate());
            rowInsert = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInsert;
    }


    public Fly getById(int id) {
        String sql = "SELECT * FROM fly WHERE fly_id =?";
        Fly fly = new Fly();
        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            fly.setId(resultSet.getInt("fly_id"));
            fly.setAir_company(resultSet.getString("air_company"));
            fly.setDate(resultSet.getDate("fly_date"));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fly;
    }

    @Override
    public Collection<Fly> getAll() {
        Collection<Fly> flyList = new ArrayList<>();
        String sql = "SELECT * FROM fly";

        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Fly fly = new Fly();
                fly.setId(resultSet.getInt("fly_id"));
                fly.setAir_company(resultSet.getString("air_company"));
                fly.setDate(resultSet.getDate("fly_date"));
                flyList.add(fly);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flyList;
    }

    @Override
    public boolean update(Fly model) {
        String sql = "UPDATE fly SET air_company = ?, fly_date = ? WHERE fly_id = ?";
        boolean rowUpdate = false;
        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(3, model.getId());
            preparedStatement.setString(1, model.getAir_company());
            preparedStatement.setDate(2, model.getDate());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public boolean delete(Fly model) {
        String sql = "DELETE FROM fly WHERE fly_id= ?";
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
