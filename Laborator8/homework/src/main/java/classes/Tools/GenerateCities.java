package classes.Tools;

import classes.DAO.CityDAO;
import classes.Database.Database;
import classes.Object.City;
import com.github.javafaker.Faker;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateCities {
    private List<City> randomCities = new ArrayList<>();

    public List<City> generate(int number) {
        City newCity;
        Random random = new Random();
        Faker faker = new Faker();
        Float lat, lon;

        for(int i = 0; i < number; i++) {
            lat = random.nextFloat(300);
            lon = random.nextFloat(300);
            int x = random.nextInt(2);
            if (x == 1)
                lat = -lat;
            x = random.nextInt(2);
            if (x == 1)
                lon = -lon;
            newCity = new City(faker.funnyName().name(), 1, true, lat, lon);
            var cities = new CityDAO();
            try {
                cities.create(newCity);
                Database.getConnection().commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            randomCities.add(newCity);
        }
        return randomCities;
    }
}
