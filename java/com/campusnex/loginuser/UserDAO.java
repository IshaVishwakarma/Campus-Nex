package com.campusnex.loginuser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/MajorProject";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Ishamysql@0902";

    private static final String SELECT_USER_BY_ENROLLMENT_NO_AND_PASSWORD = "SELECT * FROM Students WHERE enrollment_no = ? AND password = ?";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public User checkLogin(String enrollmentNo, String password) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ENROLLMENT_NO_AND_PASSWORD)) {
            preparedStatement.setString(1, enrollmentNo);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
            	User user = new User("enrollmentNoValue", "passwordValue", "nameValue", "emailValue");

                user.setEnrollmentNo(resultSet.getString("enrollment_no"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
