package dao.daoImpl;

import Util.DBUtil;
import dao.UserDAO;
import model.User;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDatabaseDAO  implements UserDAO {
    DBUtil dbUtil;







    @Override
    public User getAuthorization(String login, String password) {
        String sql = "SELECT login, password FROM user";
        User user = null;
        try(Connection connection = dbUtil.getDataSource().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean create(User model) {
        String insertUser = "INSERT INTO user(" +
                "login" +
                "name," +
                "lastname," +
                "email," +
                " password, " +
                "create_date" +
                "user_dob," +
                " roles_id)" +
                " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        boolean rowInserted = false;
        try (Connection connection = dbUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertUser)) {
            preparedStatement.setString(1, model.getLogin());
            preparedStatement.setString(2, model.getName());
            preparedStatement.setString(3, model.getLastName());
            preparedStatement.setString(4, model.getEmail());
            preparedStatement.setString(5, model.getPassword());
            preparedStatement.setDate(6, model.getUserDOB());    //переделать
            preparedStatement.setDate(7, model.getUserDOB());
            preparedStatement.setInt(8, model.getRoles());
            rowInserted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInserted;
    }

    @Override
    public User getById(int id) {
        String sql = "SELECT * FROM user WHERE user_id =?";
        User user = new User();
        try (Connection connection = dbUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            user.setId(resultSet.getInt("user_id"));
            user.setLogin(resultSet.getString("login"));
            user.setName(resultSet.getString("name"));
            user.setLastName(resultSet.getString("lastname"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            user.setCreateDate(resultSet.getDate("create_date"));
            user.setUserDOB(resultSet.getDate("user_dob"));
            user.setRoles(resultSet.getInt("roles_id"));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getAll() {
                List<User> userList = new ArrayList<>();

        String sql = "SELECT * FROM user";

        try (Connection connection = dbUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("user_id"));
                user.setLogin(resultSet.getString("login"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastname"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setCreateDate(resultSet.getDate("create_date"));
                user.setUserDOB(resultSet.getDate("user_dob"));
                user.setRoles(resultSet.getInt("roles_id"));

                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
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
        try (Connection connection = dbUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(8, model.getId());
            preparedStatement.setString(1, model.getLogin());
            preparedStatement.setString(2, model.getName());
            preparedStatement.setString(3, model.getLastName());
            preparedStatement.setString(4, model.getEmail());
            preparedStatement.setString(5, model.getPassword());
            preparedStatement.setDate(6, model.getUserDOB());
            preparedStatement.setInt(7, model.getRoles());

            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public boolean delete(User model) {
                String sql = "DELETE FROM fly where fly_id =?";
        boolean rowDelete = false;
        try (Connection connection = dbUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, model.getId());
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }

    @Override
    public User getUserByOrder(int orderId) {
        User user = null;
        String sql = "SELECT u.user_id, u.login, u.name, u.lastname, u.email, u.password," +
                " u.create_date, u.user_dob, u.roles_id" +
                " FROM `order` o JOIN user u on o.user_id = u.user_id WHERE o.id =?";
        try(Connection connection = dbUtil.getDataSource().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, orderId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user = getUserFromDb(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean updateUserPassword(int userID, String password) {

        String sql = "UPDATE user SET password = ? where user_id = ?";
        return updateUserAttribute(userID,password,sql);
    }

    @Override
    public boolean updateName(int userID, String name) {
        String sql = "UPDATE user SET name = ? where user_id = ?";
        return updateUserAttribute(userID, name,sql);
    }

    @Override
    public boolean updateLastName(int userID, String lastName){
        String sql = "UPDATE user SET lastname = ? where user_id = ?";
        return updateUserAttribute(userID, lastName,sql);
    }

    @Override
    public boolean updateEmail(int userID, String email) {
        String sql = "UPDATE user SET email = ? where user_id = ?";
        return updateUserAttribute(userID, email,sql);
    }

    @Override
    public boolean updateRoles(int userID, int rolesID) {
        String sql = "UPDATE user SET roles_id = ? where user_id = ?";
        boolean rowUpdateRoles = false;
        try (Connection connection = dbUtil.getDataSource().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,userID);
            preparedStatement.setInt(2,rolesID);
            rowUpdateRoles = preparedStatement.executeUpdate() >0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdateRoles;
    }

    @Override
    public boolean updateUserDob(int userID, Date userBirth) {
        String sql = "UPDATE user SET user_dob=? WHERE user_id = ?";
        boolean rowUpdateDob = false;
        try(Connection connection = dbUtil.getDataSource().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDate(1, userBirth);
            preparedStatement.setInt(2, userID);
            rowUpdateDob = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdateDob;
    }

    // Utility methods
    private static User getUserFromDb(ResultSet rs) throws SQLException {
        UserDatabaseDAO oDao = new UserDatabaseDAO();
        User user = new User(rs.getInt("user_id"), rs.getString("login"), rs.getString("name"),
                rs.getString("lastname"),rs.getString("email"), rs.getString("password"),
                rs.getDate("create_date"), rs.getDate("user_dob"), rs.getInt("roles_id"));

        return user;
    }

    private boolean updateUserAttribute(int userId, String attribute, String sql) {
        boolean rowUpdate = false;
        try (Connection connection = dbUtil.getDataSource().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, attribute);
            preparedStatement.setInt(2, userId);
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

}
