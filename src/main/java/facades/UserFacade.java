package facades;

import dao.daoImpl.UserDatabaseDAO;
import model.User;

import java.sql.Date;
import java.util.List;

public class UserFacade {
    UserDatabaseDAO userDB= new UserDatabaseDAO();

    public List<User> getUsers(){
        return userDB.getAll();
    }

    public User getUserbyID(int id){
        return userDB.getById(id);
    }

    public boolean creteUser(User user){
        return userDB.create(user);
    }

    public boolean updateUser(User user){
        return userDB.update(user);
    }

    public boolean deleteUser(User user){
        return userDB.delete(user);
    }

    public boolean updateUserBirth(int userId, Date deteOfBirth){
        return userDB.updateUserDob(userId, deteOfBirth);
    }

    public boolean updateUserName(int userId, String name){
        return userDB.updateName(userId,name);
    }

    public boolean updateUserLastName(int userId, String lastname){
        return userDB.updateLastName(userId, lastname);
    }

    public boolean updateUserPassword(int userId, String password){
        return userDB.updateUserPassword(userId, password);
    }

    public boolean updateUserMail(int userId, String email){
        return userDB.updateEmail(userId, email);
    }

    public boolean updateUserRole(int userId, int roleId){
        return userDB.updateRoles(userId, roleId);
    }

    public User getUserByOrder(int orderId){
        return  userDB.getUserByOrder(orderId);
    }
}
