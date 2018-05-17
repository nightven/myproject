package model;

import java.sql.Date;

public class Order extends Model {
    private User user;
    private Tours tours;
    private int user_id = user.getId();
    private int tours_d = tours.getId();
    private Date createDate;

    public Order() {
        super();
    }

    public Order(int id) {
        super(id);
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTours_d() {
        return tours_d;
    }

    public void setTours_id(int tours_d) {
        this.tours_d = tours_d;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


}
