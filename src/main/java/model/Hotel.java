package model;

import java.sql.Date;

public class Hotel extends Model {


    private String hotelName;
    private int hotelStar;
    private Date date;

    public Hotel() {
        super();
    }

    public Hotel(int id) {
        super(id);
    }


    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getHotelStar() {
        return hotelStar;
    }

    public void setHotelStar(int hotelStar) {
        this.hotelStar = hotelStar;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
