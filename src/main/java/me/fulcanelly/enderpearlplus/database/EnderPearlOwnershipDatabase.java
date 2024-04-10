package me.fulcanelly.enderpearlplus.database;

import lombok.SneakyThrows;
import java.sql.*;

public class EnderPearlOwnershipDatabase {
    static {
        initializeTable();
    }

    @SneakyThrows
    private static void initializeTable() {
        try (Connection conn = connect();
                Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS ender_pearl_records (" +
                    "pearl_uuid TEXT PRIMARY KEY," +
                    "username TEXT NOT NULL," +
                    "created_at DATETIME DEFAULT CURRENT_TIMESTAMP)";
            stmt.execute(sql);
        }
    }

    @SneakyThrows
    private static Connection connect() {
        // TODO
        String url = "jdbc:sqlite:pearl_database.db";
        return DriverManager.getConnection(url);
    }

    @SneakyThrows
    public String getOwnerOfPerl(String uuid) {
        String sql = "SELECT username FROM ender_pearl_records WHERE pearl_uuid = ?";

        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, uuid);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getString("username");
            }
        }
        return null;
    }

    @SneakyThrows
    public void removeRecord(String uuid) {
        String sql = "DELETE FROM ender_pearl_records WHERE pearl_uuid = ?";

        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, uuid);
            pstmt.executeUpdate();

        }
    }

    @SneakyThrows
    public void createRecord(String username, String uuid) {
        String sql = "INSERT INTO ender_pearl_records(pearl_uuid, username) VALUES(?,?)";

        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, uuid);
            pstmt.setString(2, username);
            pstmt.executeUpdate();
        }
    }
}
