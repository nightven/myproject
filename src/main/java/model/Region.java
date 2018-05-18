package model;

public class Region extends Model {

    private String region;

    public Region() {
        super();
    }

    public Region(int id) {
        super(id);
    }


    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
