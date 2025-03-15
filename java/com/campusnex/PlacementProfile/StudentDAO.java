package com.campusnex.PlacementProfile;
import java.sql.*;

public class StudentDAO {
    // JDBC URL, username, and password of MySQL server
    private static final String URL = "jdbc:mysql://localhost:3306/MajorProject";
    private static final String USER = "root";
    private static final String PASSWORD = "Ishamysql@0902";

    // JDBC variables for opening and managing connection
    private static Connection connection;
    private static PreparedStatement preparedStatement;

    // SQL queries
    private static final String SELECT_BY_ENROLLMENT = "SELECT * FROM placement_profile WHERE enrollment_no = ?";
    private static final String INSERT_PROFILE = "INSERT INTO  placement_profile(enrollment_no, domain, resume, cgpa, internship, certification) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_PROFILE = "UPDATE placement_profile SET domain=?, resume=?, cgpa=?, internship=?, certification=? WHERE enrollment_no=?";

    public StudentDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Student getStudentByEnrollment(String enrollmentNo) {
        try {
            preparedStatement = connection.prepareStatement(SELECT_BY_ENROLLMENT);
            preparedStatement.setString(1, enrollmentNo);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Student(
                        resultSet.getString("enrollment_no"),
                        resultSet.getString("domain"),
                        resultSet.getString("resume"),
                        resultSet.getDouble("cgpa"),
                        resultSet.getBoolean("internship"),
                        resultSet.getBoolean("certification")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addStudentProfile(Student student) {
        try {
            preparedStatement = connection.prepareStatement(INSERT_PROFILE);
            preparedStatement.setString(1, student.getEnrollmentNo());
            preparedStatement.setString(2, student.getDomain());
            preparedStatement.setString(3, student.getResume());
            preparedStatement.setDouble(4, student.getCgpa());
            preparedStatement.setBoolean(5, student.hasInternship());
            preparedStatement.setBoolean(6, student.hasCertification());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudentProfile(Student student) {
        try {
            preparedStatement = connection.prepareStatement(UPDATE_PROFILE);
            preparedStatement.setString(1, student.getDomain());
            preparedStatement.setString(2, student.getResume());
            preparedStatement.setDouble(3, student.getCgpa());
            preparedStatement.setBoolean(4, student.hasInternship());
            preparedStatement.setBoolean(5, student.hasCertification());
            preparedStatement.setString(6, student.getEnrollmentNo());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
