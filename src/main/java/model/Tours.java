package model;

import java.sql.Date;

public class Tours extends Model {
    private Hotel hotel;
    private Fly fly;
    private Region region;
    private String nameTour;
    private String description;
    private Date detaTour;
    private double costTour;
    private int hotel_id = hotel.getId();
    private int fly_id = fly.getId();
    private int region_id = region.getId();

    public Tours() {
        super();
    }

    public Tours(int id) {
        super(id);
    }


    public String getNameTour() {
        return nameTour;
    }

    public void setNameTour(String nameTour) {
        this.nameTour = nameTour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDetaTour() {
        return detaTour;
    }

    public void setDetaTour(Date detaTour) {
        this.detaTour = detaTour;
    }

    public double getCostTour() {
        return costTour;
    }

    public void setCostTour(double costTour) {
        this.costTour = costTour;
    }


    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public int getFly_id() {
        return fly_id;
    }

    public void setFly_id(int fly_id) {
        this.fly_id = fly_id;
    }

    public int getRegion_id() {
        return region_id;
    }

    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }
}
