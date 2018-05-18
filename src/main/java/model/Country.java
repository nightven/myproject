package model;

public class Country extends Model {
    private int id;
    private String cityName;
    private String country;


    public Country() {
        super();
    }

    public Country(int id) {
        super(id);
    }


    public Country(int id, int id1, String cityName, String country) {
        super(id);
        this.id = id1;
        this.cityName = cityName;
        this.country = country;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
