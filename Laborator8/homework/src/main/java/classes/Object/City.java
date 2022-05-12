package classes.Object;

import java.util.List;

public class City {
    private int id;
    private int country_id;
    private String name;
    private Boolean capital;
    private Float latitude;
    private Float longitude;

    public City(String name, int country_id, Boolean capital, Float latitude, Float longitude) {
        this.country_id = country_id;
        this.name = name;
        this.capital = capital;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public City() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCapital() {
        return capital;
    }

    public void setCapital(Boolean capital) {
        this.capital = capital;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", country_id=" + country_id +
                ", name='" + name + '\'' +
                ", capital=" + capital +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
