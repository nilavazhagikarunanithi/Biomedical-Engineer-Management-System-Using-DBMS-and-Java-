package dao;
import db.DBConnection;
import models.Equipment;
import java.sql.*;
import java.util.*;

public class EquipmentDAO {
    public void addEquipment(Equipment eq) throws SQLException {
        String sql = "INSERT INTO equipment (name, type, status) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, eq.name);
            stmt.setString(2, eq.type);
            stmt.setString(3, eq.status);
            stmt.executeUpdate();
        }
    }

    public List<Equipment> getAllEquipment() throws SQLException {
        List<Equipment> list = new ArrayList<>();
        String sql = "SELECT * FROM equipment";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Equipment eq = new Equipment(rs.getString("name"),
                        rs.getString("type"), rs.getString("status"));
                eq.equipmentId = rs.getInt("equipment_id");
                list.add(eq);
            }
        }
        return list;
    }
}
