package classes.DAO;

import classes.Database.Database;
import classes.Object.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDAO {

    public void create(String name, int id, Boolean capital, Float latitude, Float longitude) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into cities (id_country, name, capital, latitude, longitude) values (?, ?, ?, ?, ?)")) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setBoolean(3, capital);
            pstmt.setFloat(4, latitude);
            pstmt.setFloat(5, longitude);
            pstmt.executeUpdate();
        }
    }

    public City findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        City city = null;
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id, id_country, capital, latitude, longitude from cities where name='" + name + "'")) {

            if (rs.next()) {
                city = new City();
                city.setId(rs.getInt(1));
                city.setCountry_id(rs.getInt(2));
                city.setName(name);
                city.setCapital(rs.getBoolean(3));
                city.setLatitude(rs.getFloat(4));
                city.setLongitude(rs.getFloat(5));
            }
        }
        return city;
    }

    public City findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        City city = null;
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id_country, name, capital, latitude, longitude from cities where id='" + id + "'")) {
            if (rs.next()) {
                city = new City();
                city.setId(id);
                city.setCountry_id(rs.getInt(1));
                city.setName(rs.getString(2));
                city.setCapital(rs.getBoolean(3));
                city.setLatitude(rs.getFloat(4));
                city.setLongitude(rs.getFloat(5));
            }
        }
        return city;
    }

    public List<City> findByCountryId(Integer countryId) throws SQLException {
        Connection con = Database.getConnection();
        City city = null;
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id, name, capital, latitude, longitude from countries where id_country='" + countryId + "'")) {

            List<City> result = new ArrayList<City>();
            int index = 0;

            while (rs.next()) {
                city = new City();
                city.setId(rs.getInt(1));
                city.setCountry_id(countryId);
                city.setName(rs.getString(2));
                city.setCapital(rs.getBoolean(3));
                city.setLatitude(rs.getFloat(4));
                city.setLongitude(rs.getFloat(5));
                result.add(city);
            }
            return result;
        }
    }
}
