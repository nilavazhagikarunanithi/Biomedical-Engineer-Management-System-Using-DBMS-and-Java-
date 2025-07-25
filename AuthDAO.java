package dao;
import db.DBConnection;
import java.sql.*;

public class AuthDAO {
    public boolean login(String username, String password) throws SQLException {
        String sql = "SELECT * FROM users WHERE username=? AND password=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password); // in real apps, use hashed passwords
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        }
    }
}
