package com.dashboard.student;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/studentDashboard")
public class StudentDashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String enrollmentNo = request.getParameter("enrollmentNo");
        User user = UserDAO.getUserByEnrollmentNo(enrollmentNo);
        
        if (user != null) {
            request.setAttribute("user", user);
            request.getRequestDispatcher("student_dashboard.jsp").forward(request, response);
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
