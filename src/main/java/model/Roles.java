package model;

public class Roles extends Model {

    private int access; //1 = admin, 2= manager, 3 = user.

    public Roles() {
        super();
    }

    public Roles(int id) {
        super(id);
    }


    public int getAccess() {
        return access;
    }

    public void setAccess(int eccess) {
        this.access = eccess;
    }


}
