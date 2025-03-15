package com.campusnex.studentlist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAOImpl implements StudentDAO {

    // Assuming your database credentials
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/MajorProject";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "Ishamysql@0902";

    @Override
    public PersonalProfile getPersonalProfile(String enrollmentNo) {
        PersonalProfile personalProfile = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Establishing database connection
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);

            // Preparing SQL query
            String sql = "SELECT * FROM personal_information WHERE enrollment_no = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, enrollmentNo);

            // Executing query
            rs = stmt.executeQuery();

            // Processing result set
            if (rs.next()) {
                // Retrieve fields from the result set
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                String contactNo = rs.getString("contact_no");
                String email = rs.getString("email");
                
                // Create a new PersonalProfile object with the retrieved data
                personalProfile = new PersonalProfile(enrollmentNo, name, gender, contactNo, email);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception as per your requirement
        } finally {
            // Closing resources
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Handle or log the exception as per your requirement
            }
        }
        return personalProfile;
    }

    @Override
    public PlacementProfile getPlacementProfile(String enrollmentNo) {
        PlacementProfile placementProfile = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Establishing database connection
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);

            // Preparing SQL query
            String sql = "SELECT * FROM placement_profile WHERE enrollment_no = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, enrollmentNo);

            // Executing query
            rs = stmt.executeQuery();

            // Processing result set
            if (rs.next()) {
                // Retrieve fields from the result set
                String domain = rs.getString("domain");
                double cgpa = rs.getDouble("cgpa");
                
                // Create a new PlacementProfile object with the retrieved data
                placementProfile = new PlacementProfile(enrollmentNo, domain, cgpa);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception as per your requirement
        } finally {
            // Closing resources
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Handle or log the exception as per your requirement
            }
        }
        return placementProfile;
    }
}
