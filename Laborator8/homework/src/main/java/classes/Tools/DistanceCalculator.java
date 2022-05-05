package classes.Tools;

import classes.DAO.CityDAO;

import java.sql.SQLException;

public class DistanceCalculator {
    public void Calculate(int id1, int id2) {
        Double latitudeCity1 = 0.0, longitudeCity1 = 0.0, latitudeCity2 = 0.0, longitudeCity2 = 0.0;

        var City1 = new CityDAO();
        var City2 = new CityDAO();
        String nameCity1 = null, nameCity2 = null;
        try {
            latitudeCity1 = Double.valueOf(City1.findById(id1).getLatitude());
            longitudeCity1 = Double.valueOf(City1.findById(id1).getLongitude());
            nameCity1 = City1.findById(id1).getName();

            latitudeCity2 = Double.valueOf(City2.findById(id2).getLatitude());
            longitudeCity2 = Double.valueOf(City2.findById(id2).getLongitude());
            nameCity2 = City1.findById(id2).getName();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        longitudeCity1 = Math.toRadians(longitudeCity1);
        longitudeCity2 = Math.toRadians(longitudeCity2);
        latitudeCity1 = Math.toRadians(latitudeCity1);
        latitudeCity2 = Math.toRadians(latitudeCity2);

        double dlon = longitudeCity2 - longitudeCity1;
        double dlat = latitudeCity2 - latitudeCity1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(latitudeCity1) * Math.cos(latitudeCity2)
                * Math.pow(Math.sin(dlon / 2), 2);

        double c = 2 * Math.asin(Math.sqrt(a));

        double r = 6371;

        System.out.println("Distanta dintre " + nameCity1 + " si " + nameCity2 + " este de " + (c * r) + " km");
    }
}
