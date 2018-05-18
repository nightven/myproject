package dao;


import model.User;

import java.sql.Date;


public interface UserDAO extends ItemDAO<User> {

    public User getAuthorization(String login, String password);

    public User getUserByOrder(int orderId);

    public boolean updateUserPassword(int userID, String password);

    public boolean updateName(int userID, String name);

    public boolean updateLastName(int userID, String lastName);

    public boolean updateEmail(int userID, String email);

    public boolean updateRoles(int userID, int rolesID);

    public boolean updateUserDob(int userID, Date userBirth);


}
