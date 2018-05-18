package facades;

import dao.daoImpl.RolesDatabaseDAO;
import model.Roles;

import java.util.List;

public class RolesFacade {
    RolesDatabaseDAO roleDB = new RolesDatabaseDAO();

    public  boolean createRole(Roles roles){
        return  roleDB.create(roles);
    }

    public Roles getRolebyId(int roleId){
        return roleDB.getById(roleId);
    }

    public List<Roles> getAllRoles(){
        return roleDB.getAll();
    }

    public  boolean updateRole(Roles roles){
        return roleDB.update(roles);
    }

    public boolean deleteRole(Roles roles){
        return roleDB.delete(roles);
    }
}
