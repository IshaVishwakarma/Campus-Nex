package com.campusnex.academicdetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AcademicDetailsDAO {
    private Connection conn;

    // Method to establish database connection
    private void connect() throws SQLException {
        // Replace the connection URL, username, and password with your database credentials
        String url = "jdbc:mysql://localhost:3306/MajorProject";
        String username = "root";
        String password = "Ishamysql@0902";
        
        conn = DriverManager.getConnection(url, username, password);
    }

    // Constructor
    public AcademicDetailsDAO() throws SQLException {
        connect(); 
        conn.setAutoCommit(true);// Establish database connection
    }

    // Method to retrieve academic details by enrollment number
    public AcademicDetails getAcademicDetails(String enrollmentNo) throws SQLException {
        String query = "SELECT * FROM Students WHERE enrollment_no=?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, enrollmentNo);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            // Retrieve data from ResultSet and create AcademicDetails object
            AcademicDetails academicDetails = new AcademicDetails();
            academicDetails.setEnrollmentNo(rs.getString("enrollment_no"));
            academicDetails.setDepartment(rs.getString("department"));
            academicDetails.setPassingOutYear(rs.getInt("passing_out_year"));
            academicDetails.setCurrentCGPA(rs.getDouble("current_cgpa"));
            academicDetails.setMarksheetPath(rs.getString("marksheet_path"));
            // Set other attributes similarly

            return academicDetails;
        } else {
            return null; // No data found
        }
    }

    // Method to update academic details
    public void updateAcademicDetails(AcademicDetails academicDetails) {
        String query = "UPDATE Students SET department=?, passing_out_year=?, current_cgpa=?, marksheet_path=? WHERE enrollment_no=?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            // Set parameters for the query
            pstmt.setString(1, academicDetails.getDepartment());
            pstmt.setInt(2, academicDetails.getPassingOutYear());
            pstmt.setDouble(3, academicDetails.getCurrentCGPA());
            pstmt.setString(4, academicDetails.getMarksheetPath());
            pstmt.setString(5, academicDetails.getEnrollmentNo());
            System.out.println("Passing Out Year: " + academicDetails.getPassingOutYear());
           

           
            
            // Execute the query
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Academic details updated successfully.");
            } //else {
                //System.out.println("Failed to update academic details. No rows affected.");
            //}
        } catch (SQLException e) {
            System.err.println("Failed to update academic details: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void insertAcademicDetails(AcademicDetails academicDetails) throws SQLException {
        String query = "UPDATE Students SET department=?, passing_out_year=?, current_cgpa=?, marksheet_path=? WHERE enrollment_no=?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            // Set parameters for the query
        	pstmt.setString(1, academicDetails.getEnrollmentNo());
            pstmt.setString(2, academicDetails.getDepartment());
            pstmt.setInt(3, academicDetails.getPassingOutYear());
            pstmt.setDouble(4, academicDetails.getCurrentCGPA());
            pstmt.setString(5, academicDetails.getMarksheetPath());
            

            // Execute the query
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Academic details inserted successfully.");
            } //else {
                //System.out.println("Failed to insert academic details. No rows affected.");
            //}
        } catch (SQLException e) {
            System.err.println("Failed to insert academic details: " + e.getMessage());
            throw e; // Re-throw the exception to handle it in the servlet
        }
    }
    // Method to close database connection
    public void close() {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("Error while closing connection: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
