package com.dashboard.student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/MajorProject";
    private static final String JDBC_USER = "root"; // Assuming your MySQL username is root
    private static final String JDBC_PASSWORD = "Ishamysql@0902";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public static User getUserByEnrollmentNo(String enrollmentNo) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = null;
        
        try {
            connection = getConnection();
            String query = "SELECT enrollment_no, name, email FROM Students WHERE enrollment_no = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, enrollmentNo);
            resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                user = new User();
                user.setEnrollmentNo(resultSet.getString("enrollment_no"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return user;
    }
}
