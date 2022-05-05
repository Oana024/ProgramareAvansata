package classes.Tools;

import classes.DAO.CityDAO;
import classes.DAO.ContinentDAO;
import classes.DAO.CountryDAO;
import classes.Database.Database;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class WordCapitals {

    public void add() {
        try (CSVReader reader = new CSVReader(new FileReader("src/main/resources/concap.csv"))) {
            var line = reader.readNext();
            while (line != null) {

                line[0] = line[0].replaceAll("[^A-Za-z0-9]", "");
                line[1] = line[1].replaceAll("[^A-Za-z0-9]", "");
                line[2] = line[2].replaceAll("[^A-Za-z0-9]", "");
                line[3] = line[3].replaceAll("[^A-Za-z0-9]", "");
                line[4] = line[4].replaceAll("[^A-Za-z0-9]", "");
                line[5] = line[5].replaceAll("[^A-Za-z0-9]", "");

                var continent = new ContinentDAO();
                var country = new CountryDAO();
                var city = new CityDAO();

                continent.create(line[0]);
                Database.getConnection().commit();

                country.create(line[1], continent.findByName(line[0]).getId(), line[2]);
                Database.getConnection().commit();

                city.create(line[3], country.findByName(line[1]).getId(), true, Float.parseFloat(line[4]), Float.parseFloat(line[5]));
                Database.getConnection().commit();

                line = reader.readNext();
            }
        } catch (CsvValidationException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
