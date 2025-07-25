package db;
import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/biomedical_db";
    private static final String USER = "root"; // update if needed
    private static final String PASSWORD = ""; // update if needed

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
