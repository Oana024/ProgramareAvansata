package classes.DAO;

import classes.Database.Database;
import classes.Object.Continent;

import java.sql.*;

public class ContinentDAO {

    public void create(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into continents (name) values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }

    public Continent findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        Continent continent = null;
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id  from continents where name='" + name + "'")) {
            if(rs.next()){
                continent = new Continent();
                continent.setName(name);
                continent.setId(rs.getInt(1));
            }
        }
        return continent;
    }

    public Continent findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        Continent continent = null;
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from continents where id='" + id + "'")) {
            if(rs.next()){
                continent = new Continent();
                continent.setId(id);
                continent.setName(rs.getString(1));
            }
        }
        return continent;
    }
}