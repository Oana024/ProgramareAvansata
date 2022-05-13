package classes.Database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {
    private static final String URL =
            "jdbc:postgresql://localhost:5432/";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";
    private static Connection connection = null;

    private Database() {
    }

    public static Connection getConnection() {
        if(connection == null) {
            createConnection();
        }
        return connection;
    }

    private static void createConnection() {
        try {

            Properties props = new Properties();
            props.setProperty("user",USER);
            props.setProperty("password",PASSWORD);
            connection = DriverManager.getConnection(URL, props);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection = null;
    }

    public static void rollback() {
    }
}