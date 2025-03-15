package com.campusnex.PersonalInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {
    private Connection connection;

    public StudentDAO() {
        try {
            // Load JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Connect to your database
            String url = "jdbc:mysql://localhost:3306/MajorProject";
            String username = "root";
            String password = "Ishamysql@0902";
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle connection error
        }
    }

    public Student getStudentByEnrollmentNo(String enrollmentNo) throws SQLException {
        Student student = null;
        String query = "SELECT * FROM personal_information WHERE enrollment_no = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, enrollmentNo);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    student = new Student();
                    student.setEnrollmentNo(rs.getString("enrollment_no"));
                    student.setName(rs.getString("name"));
                    student.setContactNo(rs.getString("contact_no"));
                    student.setGender(rs.getString("gender"));
                    student.setDob(rs.getDate("dob"));
                    student.setAddress(rs.getString("address"));
                }
            }
        }
        return student;
    }

    public void saveOrUpdateStudent(Student student) throws SQLException {
        String query;
        if (getStudentByEnrollmentNo(student.getEnrollmentNo()) != null) {
            // Student exists, update
            query = "UPDATE personal_information SET name=?, contact_no=?, gender=?, dob=?, address=? WHERE enrollment_no=?";
        } else {
            // Student doesn't exist, insert
            query = "INSERT INTO personal_information (enrollment_no, name, contact_no, gender, dob, address) VALUES (?, ?, ?, ?, ?, ?)";
        }
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getContactNo());
            pstmt.setString(3, student.getGender());
            pstmt.setDate(4, new java.sql.Date(student.getDob().getTime()));
            pstmt.setString(5, student.getAddress());
            pstmt.setString(6, student.getEnrollmentNo()); // Bind enrollment number as the last parameter for both insert and update
            pstmt.executeUpdate();
        }
    }

}