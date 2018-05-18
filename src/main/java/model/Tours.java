package model;

import java.sql.Date;

public class Tours extends Model {

    private String nameTour;
    private String description;
    private Date startDateTours;
    private Date endDateTours;
    private double costTour;


    public Tours() {
        super();
    }

    public Tours(int id) {
        super(id);
    }

    public Tours(int id, String name, String description, Date start_tour, Date end_tour, double costTour) {
        super(id);
        this.nameTour=name;
        this.description= description;
        this.startDateTours=start_tour;
        this.endDateTours=end_tour;
        this.costTour=costTour;

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

    public Date getStartDateTours() {
        return startDateTours;
    }

    public void setStartDateTours(Date startDateTours) {
        this.startDateTours = startDateTours;
    }

    public Date getEndDateTours() {
        return endDateTours;
    }

    public void setEndDateTours(Date endDateTours) {
        this.endDateTours = endDateTours;
    }

    public double getCostTour() {
        return costTour;
    }

    public void setCostTour(double costTour) {
        this.costTour = costTour;
    }
}
