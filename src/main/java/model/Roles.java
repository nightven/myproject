package model;

public class Roles extends Model {

    private int access; //1 = admin, 2= user,

    public Roles() {
        super();
    }

    public Roles(int id) {
        super(id);
    }

    public Roles(int id, int access) {
        super(id);
        this.access = access;
    }

    public int getAccess() {
        return access;
    }

    public void setAccess(int eccess) {
        this.access = eccess;
    }


}
