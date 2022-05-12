package classes.DAO;

import classes.Database.Database;
import classes.Object.City;
import classes.Object.SistersCities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SistersCitiesDAO {

    public void create(SistersCities sistersCities) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into sisters (id_city1, id_city2) values (?, ?)")) {
            pstmt.setInt(1, sistersCities.getIdCity1());
            pstmt.setInt(2, sistersCities.getIdCity2());
            pstmt.executeUpdate();
        }
    }

    public List<SistersCities> findByCityId1(Integer cityId) throws SQLException {
        Connection con = Database.getConnection();
        SistersCities sistersCities = null;
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id, id_city2 from countries where id_city1='" + cityId + "'")) {

            List<SistersCities> result = new ArrayList<>();
            int index = 0;

            while (rs.next()) {
                sistersCities = new SistersCities();
                sistersCities.setId(rs.getInt(1));
                sistersCities.setIdCity1(cityId);
                sistersCities.setIdCity2(rs.getInt(2));
                result.add(sistersCities);
            }
            return result;
        }
    }

    public List<SistersCities> findByCityId2(Integer cityId) throws SQLException {
        Connection con = Database.getConnection();
        SistersCities sistersCities = null;
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id, id_city1 from countries where id_city2='" + cityId + "'")) {

            List<SistersCities> result = new ArrayList<>();
            int index = 0;

            while (rs.next()) {
                sistersCities = new SistersCities();
                sistersCities.setId(rs.getInt(1));
                sistersCities.setIdCity1(rs.getInt(2));
                sistersCities.setIdCity2(cityId);
                result.add(sistersCities);
            }
            return result;
        }
    }
}
