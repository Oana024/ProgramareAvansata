package classes.Object;

import classes.Object.Continent;

public class Country {
    private int id;
    private String code;
    private String name;
    private int continent_id;

    public Country(String name, int continent_id, String code) {
        this.code = code;
        this.name = name;
        this.continent_id = continent_id;
    }

    public Country() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContinent_id() {
        return continent_id;
    }

    public void setContinent_id(int continent_id) {
        this.continent_id = continent_id;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", continent_id=" + continent_id +
                '}';
    }
}
