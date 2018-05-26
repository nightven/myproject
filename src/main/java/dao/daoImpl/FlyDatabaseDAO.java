package dao.daoImpl;


import Util.DBUtil;
import dao.FlyDAO;
import model.Fly;


import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class FlyDatabaseDAO implements FlyDAO {


    public FlyDatabaseDAO() {

    }
    private DataSource ds;

    public boolean create(Fly model, String inCity, String fromCity) {
        String sql = "INSERT  INTO fly(" +
                "air_company," +
                " fly_date," +
                " price," +
                "in_country_id, " +
                "in_city_name," +
                " from_country_id," +
                " from_city_name)" +
                " VALUES (?, ?, ?, " +
                "(SELECT id from country WHERE city_name = ?),?," +
                " (SELECT id FROM country WHERE city_name = ?), ?)";
        boolean rowInsert = false;
        try (Connection connection = ds.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, model.getAir_company());
            preparedStatement.setDate(2, model.getDate());
            preparedStatement.setDouble(3, model.getPrice());
            preparedStatement.setString(4, inCity);
            preparedStatement.setString(5, inCity);
            preparedStatement.setString(6, fromCity);
            preparedStatement.setString(7, fromCity);

            rowInsert = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInsert;
    }


    public Fly getFlyById(int id) {
        String sql = "SELECT fly_id, air_company, fly_date, price, in_city_name, from_city_name FROM fly WHERE fly_id =?";
        Fly fly = null;
        try (Connection connection = ds.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                fly = getFlyFromDb(resultSet);
            }

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fly;
    }

    @Override
    public List<Fly> getAll() {
        List<Fly> flyList = new ArrayList<>();
        String sql = "SELECT fly_id, air_company, fly_date, price, in_city_name, from_city_name FROM fly";

        try (Connection connection = ds.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                flyList.add(getFlyFromDb(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flyList;
    }

    @Override
    public boolean update(Fly model, String inCity, String fromCity) {
        String sql = "UPDATE fly SET " +
                "air_company = ?," +
                "fly_date = ?," +
                "price =?," +
                "in_country_id=(SELECT id FROM country WHERE city_name = ?)," +
                "in_city_name = ?," +
                "from_country_id=(SELECT id FROM country WHERE city_name = ?)," +
                "from_city_name =?" +
                "WHERE  fly_id = ?";
        boolean rowUpdate = false;
        try (Connection connection = ds.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(8, model.getId());
            preparedStatement.setString(1, model.getAir_company());
            preparedStatement.setDate(2, model.getDate());
            preparedStatement.setDouble(3, model.getPrice());
            preparedStatement.setString(4,inCity);
            preparedStatement.setString(5,inCity);
            preparedStatement.setString(6,fromCity);
            preparedStatement.setString(7, fromCity);

            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public boolean delete(int flyId) {
        String sql = "DELETE FROM fly WHERE fly_id= ?";
        boolean rowDelete = false;
        try (Connection connection = ds.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, flyId);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }

    @Override
    public List<Fly> getAllFlyByPeriod(String start, String end) {
        List<Fly> flyList = new ArrayList<>();
        String sql = "SELECT " +
                "fly_id," +
                " air_company," +
                " fly_date," +
                " price, " +
                "in_city_name, " +
                "from_city_name" +
                " FROM fly WHERE fly_date >= ? AND fly_date <= ?";
        try(Connection connection =ds.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                flyList.add(getFlyFromDb(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean setOrderFly(int orderID, int flyId) {
        String sql = "INSERT INTO fly_has_order SET fly_id = ?, Order_id = ?";
        boolean rowSetOrderFly = false;
        try(Connection connection = ds.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1,flyId);
            preparedStatement.setInt(2,orderID);

            rowSetOrderFly = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteOdrerFly(int orderId) {
        String sql = "DELETE FROM fly_has_order WHERE Order_id = ?";
        boolean rowDeleteOrderFly = false;
        try(Connection connection =ds.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, orderId);

            rowDeleteOrderFly = preparedStatement.executeUpdate()> 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleteOrderFly;
    }

    // Utility methods
    private static Fly getFlyFromDb(ResultSet rs) throws SQLException {
        return new Fly(rs.getInt("fly_id"), rs.getString("air_company"),
                rs.getDate("fly_date"), rs.getDouble("price"), rs.getString("in_city_name"),
                rs.getString("from_city_name"));

    }
}
