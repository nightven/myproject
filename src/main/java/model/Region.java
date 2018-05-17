package model;

public class Region extends Model {

    private int region;

    public Region() {
        super();
    }

    public Region(int id) {
        super(id);
    }


    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }


}
