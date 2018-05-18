package model;

import java.sql.Date;

public class Hotel extends Model {
    private String hotelName;
    private String hoteladress;
    private double price;
    private Date dateOcupancy;
    private Date dateEviction;
    private int nights;
    private String countryCityName;

    public Hotel() {
        super();
    }

    public Hotel(int id) {
        super(id);
    }

    public Hotel(int id, String hotelName, String hoteladress, double price, Date dateOcupancy, Date dateEviction, int nights, String countryCityName) {
        super(id);
        this.hotelName = hotelName;
        this.hoteladress = hoteladress;
        this.price = price;
        this.dateOcupancy = dateOcupancy;
        this.dateEviction = dateEviction;
        this.nights = nights;
        this.countryCityName = countryCityName;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHoteladress() {
        return hoteladress;
    }

    public void setHoteladress(String hoteladress) {
        this.hoteladress = hoteladress;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDateOcupancy() {
        return dateOcupancy;
    }

    public void setDateOcupancy(Date dateOcupancy) {
        this.dateOcupancy = dateOcupancy;
    }

    public Date getDateEviction() {
        return dateEviction;
    }

    public void setDateEviction(Date dateEviction) {
        this.dateEviction = dateEviction;
    }

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }

    public String getCountryCityName() {
        return countryCityName;
    }

    public void setCountryCityName(String countryCityName) {
        this.countryCityName = countryCityName;
    }
}
