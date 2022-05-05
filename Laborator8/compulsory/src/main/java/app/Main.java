package app;

import classes.DAO.ContinentDAO;
import classes.DAO.CountryDAO;
import classes.Database.Database;

import java.sql.SQLException;

public class Main {
    public static void main(String args[]) {

        try {
            var continents = new ContinentDAO();
            continents.create("Europe");
            Database.getConnection().commit();
            var countries = new CountryDAO();
            int europeId = continents.findByName("Europe");
            countries.create("Romania", europeId);
            countries.create("Ukraine", europeId);
            Database.getConnection().commit();
            System.out.println(countries.findByContinentId(europeId));
            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }
    }
}