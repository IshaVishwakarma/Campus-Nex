package com.campusnex.PersonalInfo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;


@WebServlet("/studentProfile")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDAO studentDAO;

    public void init() {
        studentDAO = new StudentDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String enrollmentNo = request.getParameter("enrollmentNo");

        try {
            Student student = studentDAO.getStudentByEnrollmentNo(enrollmentNo);
            if (student != null) {
                request.setAttribute("student", student);
            } else {
                request.setAttribute("message", "No student found with enrollment number: " + enrollmentNo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error undefined");
            return;
        }
        request.getRequestDispatcher("studentProfile.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String enrollmentNo = request.getParameter("enrollmentNo");
        String name = request.getParameter("name");
        String contactNo = request.getParameter("contactNo");
        String gender = request.getParameter("gender");
        Date dob = null;
        try {
            dob = Date.valueOf(request.getParameter("dob"));
        } catch (IllegalArgumentException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid date format");
            return;
        }
        String address = request.getParameter("address");

        Student student = new Student(enrollmentNo, name, contactNo, gender, dob, address);

        try {
            studentDAO.saveOrUpdateStudent(student);
            request.setAttribute("message", "Data saved successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error undefined");
            return;
        }

        doGet(request, response);
    }
}
