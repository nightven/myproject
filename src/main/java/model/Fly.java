package model;

import java.sql.Date;

public class Fly extends Model {
    private String air_company;
    private Date date;
    private double price;
    private String from;
    private String to;


    public Fly() {
        super();
    }

    public Fly(int id) {
        super(id);
    }

    public Fly(int id, String air_company, Date date, double price, String from, String to) {
        super(id);
        this.air_company = air_company;
        this.date = date;
        this.price = price;
        this.from = from;
        this.to = to;
    }

    public String getAir_company() {
        return air_company;
    }

    public void setAir_company(String air_company) {
        this.air_company = air_company;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
