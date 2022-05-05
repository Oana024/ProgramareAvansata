package classes.DAO;

import classes.Database.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO {

    public void create(String name, int id) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into countries (name, id_continent) values (?, ?)")) {
            pstmt.setString(1, name);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        }
    }

    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from countries where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from countries where id='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }

    public List<String> findByContinentId(Integer continentId) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from countries where id_continent='" + continentId + "'")) {

            List<String> result = new ArrayList<String>();
            int index = 0;

            while(rs.next()) {
                result.add(rs.getString(1));
            }

            return result;
        }
    }
}
