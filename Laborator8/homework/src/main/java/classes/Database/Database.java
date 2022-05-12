package classes.Database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {
    static HikariDataSource ds = new HikariDataSource();
    private static final String URL = "jdbc:postgresql://localhost:5432/";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";
    private static Connection connection = null;

    public static void createConnection() {
        ds.setJdbcUrl(URL);
        ds.setUsername(USER);
        ds.setPassword(PASSWORD);
        ds.addDataSourceProperty("cachePrepStmts", "true");
        ds.addDataSourceProperty("prepStmtCacheSize", "250");
        ds.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        ds.setAutoCommit(false);

        try {
            connection = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Database() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            createConnection();
        }
        return connection;
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