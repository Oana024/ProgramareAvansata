package classes.Tools;

import classes.DAO.CityDAO;
import classes.DAO.ContinentDAO;
import classes.DAO.CountryDAO;
import classes.Database.Database;
import classes.Object.City;
import classes.Object.Continent;
import classes.Object.Country;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WordCapitals {

    public static List<City> cities = new ArrayList<>();

    public void add() {
        try (CSVReader reader = new CSVReader(new FileReader("src/main/resources/concap.csv"))) {
            var line = reader.readNext();
            while (line != null) {

                for (int i = 0; i < 6; i++)
                    line[i] = line[i].replaceAll("[^\\p{IsAlphabetic}\\p{IsDigit}.-]", "");

                var continent = new ContinentDAO();
                var country = new CountryDAO();
                var city = new CityDAO();

                Continent newContinent = continent.findByName(line[0]);
                if (newContinent == null) {
                    newContinent = new Continent(line[0]);
                    continent.create(newContinent);
                }
                Database.getConnection().commit();

                //////////////////////////////////

                Country newCountry = country.findByName(line[1]);
                if (newCountry == null) {
                    newCountry = new Country(line[1], continent.findByName(line[0]).getId(), line[2]);
                    country.create(newCountry);
                }
                Database.getConnection().commit();

                ///////////////////////////////////

                City newCity = city.findByName(line[3]);
                if (newCity == null) {
                    newCity = new City(line[3], country.findByName(line[1]).getId(), true, Float.parseFloat(line[4]), Float.parseFloat(line[5]));
                    city.create(newCity);
                }
                cities.add(newCity);
                Database.getConnection().commit();

                line = reader.readNext();
            }
        } catch (CsvValidationException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
