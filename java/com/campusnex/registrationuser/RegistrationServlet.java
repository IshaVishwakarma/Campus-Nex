package com.campusnex.registrationuser;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String enrollmentNo = request.getParameter("enrollmentNo");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        // Check if password and confirm password match
        if (!password.equals(confirmPassword)) {
            response.sendRedirect("registration.jsp?error=passwordMismatch");
            return;
        }

        // Check if enrollment ID is more than 6 characters
        if (enrollmentNo.length() > 6) {
            response.sendRedirect("registration.jsp?error=enrollmentLength");
            return;
        }

        // Check if enrollment ID already exists
        try {
			if (enrollmentExists(enrollmentNo)) {
			    response.sendRedirect("registration.jsp?error=enrollmentExists");
			    return;
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MajorProject", "root", "Ishamysql@0902");
            String sql = "INSERT INTO Students (enrollment_no, name, email, password) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, enrollmentNo);
                statement.setString(2, name);
                statement.setString(3, email);
                statement.setString(4, password);

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    // Set success message in session attribute
                    HttpSession session = request.getSession();
                    session.setAttribute("successMessage", "Data stored successfully.");

                    // Redirect to home page
                    response.sendRedirect("Index.jsp");
                    return;
                } else {
                    response.sendRedirect("registration.jsp?error=unknownError");
                    return;
                }
            }
        } catch (SQLException ex) {
            handleSQLException(ex, response);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(); // Log the exception for debugging purposes
            response.sendRedirect("registration.jsp?error=driverNotFound");
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace(); // Log the exception for debugging purposes
                }
            }
        }
    }

    private boolean enrollmentExists(String enrollmentNo) throws SQLException {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MajorProject", "root", "Ishamysql@0902");
            String sql = "SELECT * FROM Students WHERE enrollment_no = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, enrollmentNo);
            resultSet = statement.executeQuery();

            return resultSet.next(); // If resultSet has next, enrollment already exists
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(); // Log the exception for debugging purposes
            return false;
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    private void handleSQLException(SQLException ex, HttpServletResponse response) throws IOException {
        if (ex.getErrorCode() == 1062) { // Duplicate entry error code
            response.sendRedirect("registration.jsp?error=enrollmentExists");
        } else {
            ex.printStackTrace(); // Log the exception for debugging purposes
            response.sendRedirect("registration.jsp?error=databaseError");
            String errorMessage = "SQLException occurred: " + ex.getMessage();
            System.err.println(errorMessage);
        }
    }
}
