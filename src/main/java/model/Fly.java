package model;

import java.sql.Date;

public class Fly extends Model {


    private String air_company;
    private Date date;

    public Fly() {
        super();
    }

    public Fly(int id) {
        super(id);
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


}
