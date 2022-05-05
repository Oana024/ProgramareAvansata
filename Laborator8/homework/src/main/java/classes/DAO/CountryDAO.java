package classes.DAO;

import classes.Database.Database;
import classes.Object.Continent;
import classes.Object.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO {

    public void create(String name, int id, String code) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into countries (name, id_continent, code) values (?, ?, ?)")) {
            pstmt.setString(1, name);
            pstmt.setInt(2, id);
            pstmt.setString(3, code);
            pstmt.executeUpdate();
        }
    }

    public Country findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        Country country = null;
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id, code, id_continent from countries where name='" + name + "'")) {
            if (rs.next()) {
                country = new Country();
                country.setName(name);
                country.setId(rs.getInt(1));
                country.setCode(rs.getString(2));
                country.setContinent_id(rs.getInt(3));
            }
        }
        return country;
    }

    public Country findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        Country country = null;
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name, code, id_continent from countries where id='" + id + "'")) {
            if (rs.next()) {
                country = new Country();
                country.setId(id);
                country.setName(rs.getString(1));
                country.setCode(rs.getString(2));
                country.setContinent_id(rs.getInt(3));
            }
        }
        return country;
    }

    public List<Country> findByContinentId(Integer continentId) throws SQLException {
        Connection con = Database.getConnection();
        Country country = null;
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id, name, code from countries where id_continent='" + continentId + "'")) {

            List<Country> result = new ArrayList<Country>();

            while (rs.next()) {
                country = new Country();
                country.setId(rs.getInt(1));
                country.setName(rs.getString(2));
                country.setCode(rs.getString(3));
                country.setContinent_id(continentId);
                result.add(country);
            }

            return result;
        }
    }
}
