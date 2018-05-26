package facades;

import model.User;

import java.sql.Date;

public class RegistrationFacade {
    private UserFacade userFacade = new UserFacade();

    public boolean registerUser(String login, String name, String lastname, String email, String password, Date userDob, int rolesId){
        User user = new User(login,name,lastname,email,password,userDob,rolesId);
        return userFacade.creteUser(user);
    }
}
