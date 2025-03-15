package com.campusnex.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ApplicationDAO {
    private Connection connection;

    public ApplicationDAO() {
        connection = DBConnection.getConnection();
    }

    public String getApplicationStatus(String enrollmentNo) {
        String status = null;
        String sql = "SELECT status FROM applications WHERE enrollment_no = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, enrollmentNo);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                status = resultSet.getString("status");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return status;
    }

    public boolean updateApplication(String enrollmentNo, String newStatus) {
        String selectSql = "SELECT enrollment_no FROM applications WHERE enrollment_no = ?";
        String updateSql = "UPDATE applications SET status = ? WHERE enrollment_no = ?";
        String insertSql = "INSERT INTO applications (enrollment_no, status) VALUES (?, ?)";

        try (PreparedStatement selectStatement = connection.prepareStatement(selectSql)) {
            selectStatement.setString(1, enrollmentNo);
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                // Update existing record
                try (PreparedStatement updateStatement = connection.prepareStatement(updateSql)) {
                    updateStatement.setString(1, newStatus);
                    updateStatement.setString(2, enrollmentNo);
                    int rowsUpdated = updateStatement.executeUpdate();
                    return rowsUpdated > 0;
                }
            } else {
                // Insert new record
                try (PreparedStatement insertStatement = connection.prepareStatement(insertSql)) {
                    insertStatement.setString(1, enrollmentNo);
                    insertStatement.setString(2, newStatus);
                    int rowsInserted = insertStatement.executeUpdate();
                    return rowsInserted > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
