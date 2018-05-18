package model;

import javax.naming.ldap.PagedResultsControl;
import java.sql.Date;

public class Order extends Model {
    private int userId;
    String userEmail;

    private int toursId;
    private String toursName;
    private int flyId;
    private double priceFly;
    private int hotelId;
    private double priceHotel;



    public Order() {
        super();
    }

    public Order(int id) {
        super(id);
    }

    public Order(int id, int userId, String userEmail, int toursId, String toursName, int flyId, double priceFly, int hotelId, double priceHotel) {
        super(id);
        this.userId = userId;
        this.userEmail = userEmail;
        this.toursId = toursId;
        this.toursName = toursName;
        this.flyId = flyId;
        this.priceFly = priceFly;
        this.hotelId = hotelId;
        this.priceHotel = priceHotel;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getToursId() {
        return toursId;
    }

    public void setToursId(int toursId) {
        this.toursId = toursId;
    }

    public String getToursName() {
        return toursName;
    }

    public void setToursName(String toursName) {
        this.toursName = toursName;
    }

    public int getFlyId() {
        return flyId;
    }

    public void setFlyId(int flyId) {
        this.flyId = flyId;
    }

    public double getPriceFly() {
        return priceFly;
    }

    public void setPriceFly(double priceFly) {
        this.priceFly = priceFly;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public double getPriceHotel() {
        return priceHotel;
    }

    public void setPriceHotel(double priceHotel) {
        this.priceHotel = priceHotel;
    }
}
