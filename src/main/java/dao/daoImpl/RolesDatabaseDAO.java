package dao.daoImpl;


import Util.DBUtil;
import dao.RolesDAO;
import model.Roles;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class RolesDatabaseDAO implements RolesDAO {


    public RolesDatabaseDAO() {
    }

    public boolean create(Roles model) {
        String sql = "INSERT INTO roles(access) VALUES(?) ";
        boolean rowInsert = false;
        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, model.getAccess());

            rowInsert = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInsert;
    }


    public Roles getById(int id) {
        String sql = "SELECT * FROM roles WHERE id = ?";
        Roles roles = new Roles();
        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            roles.setId(resultSet.getInt("id"));
            roles.setAccess(resultSet.getInt("access"));

            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    public Collection<Roles> getAll() {
        Collection<Roles> rolesList = new ArrayList<>();
        String sql = "SELECT * FROM roles";
        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Roles roles = new Roles();
                roles.setId(resultSet.getInt("id"));
                roles.setAccess(resultSet.getInt("access"));
                rolesList.add(roles);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rolesList;
    }

    public boolean update(Roles model) {
        String sql = "UPDATE roles SET access=? where id=?";
        boolean rowUpdate = false;
        try (Connection connection = DBUtil.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(2, model.getId());
            preparedStatement.setInt(1, model.getAccess());
            rowUpdate = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }


    public boolean delete(Roles model) {
        String sql = "DELETE FROM roles WHERE id=?";
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
