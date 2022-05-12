package app;

import classes.DAO.SistersCitiesDAO;
import classes.Database.Database;
import classes.Object.SistersCities;
import classes.Tools.Create2DMap;
import classes.Tools.DistanceCalculator;
import classes.Tools.GenerateCities;
import classes.Tools.WordCapitals;
import com.github.javafaker.Faker;

import java.sql.SQLException;
import java.util.Random;

public class Main {
    public static void main(String args[]) {

        WordCapitals wordCapitals = new WordCapitals();
        wordCapitals.add();

        DistanceCalculator distanceCalculator = new DistanceCalculator();

        distanceCalculator.Calculate(1, 2);
        distanceCalculator.Calculate(7, 10);
        distanceCalculator.Calculate(21, 44);
        distanceCalculator.Calculate(4, 9);

        Create2DMap map = new Create2DMap(WordCapitals.cities);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        GenerateCities generateCities = new GenerateCities();
//        Create2DMap map = new Create2DMap(generateCities.generate(1500));
//
//        SistersCitiesDAO sistersCitiesDAO = new SistersCitiesDAO();
//        SistersCities sistersCities;
//
//        Random random = new Random();
//        for(int i = 1; i <= 1500; i++)
//            for(int j = 1; j <= 1500; j++) {
//                if(i != j) {
//                    int p = random.nextInt(2000);
//                    if (p < 1) {
//                        sistersCities = new SistersCities(i, j);
//                        try {
//                            sistersCitiesDAO.create(sistersCities);
//                            Database.getConnection().commit();
//                        } catch (SQLException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }

        Database.closeConnection();
    }
}