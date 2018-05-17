package daoImpl;

import Util.DBUtil;
import dao.UserDAO;
import model.Roles;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class UserDatabaseDAO extends DBUtil implements UserDAO {
        Roles roles;

    public UserDatabaseDAO() {
    }


    //boolesn
    public boolean create(User model) {
        String insertUser = "INSERT INTO user(" +
                "login" +
                "user_name," +
                "lastname," +
                "email," +
                " password, " +
                "create_date" +
                "user_dob," +
                " access_access_id)" +
                " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        boolean rowInserted = false;
        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertUser)) {
            preparedStatement.setString(1, model.getLogin());
            preparedStatement.setString(2, model.getUserName());
            preparedStatement.setString(3, model.getUserLastName());
            preparedStatement.setString(4, model.getEmailUser());
            preparedStatement.setString(5, model.getPassword());
            preparedStatement.setDate(6, model.getUserDOB());    //переделать
            preparedStatement.setDate(7, model.getUserDOB());
            preparedStatement.setInt(8, roles.getId());
            rowInserted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInserted;
    }


    public boolean update(User model) {
        String sql = "UPDATE user SET " +
                "login = ?," +
                " name = ?," +
                " lastname= ?," +
                " email = ?," +
                " password = ?," +
                " user_dob =?," +
                " roles_id = ?" +
                " WHERE user_id = ?";
        boolean rowUpdate = false;
        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, model.getLogin());
            preparedStatement.setString(2, model.getUserName());
            preparedStatement.setString(3, model.getUserLastName());
            preparedStatement.setString(4, model.getEmailUser());
            preparedStatement.setString(5, model.getPassword());
            preparedStatement.setDate(6, model.getUserDOB());
            preparedStatement.setInt(7, model.getRoles_id());

            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }


    public User getById(int id) {
        String sql = "SELECT * FROM user WHERE user_id =?";
        User user = new User();
        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            user.setId(resultSet.getInt("user_id"));
            user.setLogin(resultSet.getString("login"));
            user.setUserName(resultSet.getString("name"));
            user.setUserLastName(resultSet.getString("lastname"));
            user.setEmailUser(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            user.setCreateDate(resultSet.getDate("create_date"));
            user.setUserDOB(resultSet.getDate("user_dob"));
            user.setRoles_id(resultSet.getInt("roles_id"));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    public Collection<User> getAll() {
        Collection<User> userList = new ArrayList<>();

        String sql = "SELECT * FROM user";

        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                User user = new User();
                Roles roles = new Roles();
                user.setId(resultSet.getInt("user_id"));
                user.setLogin(resultSet.getString("login"));
                user.setUserName(resultSet.getString("name"));
                user.setUserLastName(resultSet.getString("lastname"));
                user.setEmailUser(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setCreateDate(resultSet.getDate("create_date"));
                user.setUserDOB(resultSet.getDate("user_dob"));
                roles.setId(resultSet.getInt("roles_id"));

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }


    public boolean delete(User model) {
        String sql = "DELETE FROM fly where fly_id =?";
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
