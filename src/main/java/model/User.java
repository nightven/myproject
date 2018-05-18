package model;

import java.sql.Date;
import java.util.List;

public class User extends Model {
    private String login;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private Date createDate;
    private Date userDOB;
    private int roles;

    List<Order> orderList;

    public User() {
        super();
    }

    public User(int id) {
        super(id);
    }

    public User(String login, String password){
        this.login = login;
        this.password=password;
    }

    public User(int id, String login, String name, String lastName, String email,
                String password, Date createDate, Date userDOB, int roles) {
        super(id);
        this.login = login;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.createDate = createDate;
        this.userDOB = userDOB;
        this.roles = roles;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUserDOB() {
        return userDOB;
    }

    public void setUserDOB(Date userDOB) {
        this.userDOB = userDOB;
    }

    public int getRoles() {
        return roles;
    }

    public void setRoles(int roles) {
        this.roles = roles;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
