package com.campusnex.PlacementProfile;
import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/placementProfile")
public class PlacementProfileServlet extends HttpServlet {
    private StudentDAO studentDAO;

    public void init() throws ServletException {
        studentDAO = new StudentDAO(); // Initialize DAO
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String enrollmentNo = request.getParameter("enrollmentNo");
        Student student = studentDAO.getStudentByEnrollment(enrollmentNo);
        if (student != null) {
            request.setAttribute("student", student);
            request.getRequestDispatcher("viewprofile.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("enterProfile.jsp").forward(request, response);
        }
        }
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String enrollmentNo = request.getParameter("enrollmentNo");
        String domain = request.getParameter("domain");
        String resume = request.getParameter("resume");
        String cgpaString = request.getParameter("cgpa");
        String internshipString = request.getParameter("internship");
        String certificationString = request.getParameter("certification");

        // Check for null values before trimming and parsing
        double cgpa = 0.0;
        boolean internship = false;
        boolean certification = false;

        if (cgpaString != null && !cgpaString.trim().isEmpty()) {
            cgpa = Double.parseDouble(cgpaString.trim());
        }

        if (internshipString != null) {
            internship = internshipString.trim().equalsIgnoreCase("yes");
        }

        if (certificationString != null) {
            certification = certificationString.trim().equalsIgnoreCase("yes");
        }

        // Create Student object
        Student student = new Student(enrollmentNo, domain, resume, cgpa, internship, certification);

        // Save or update the student's profile
        if (studentDAO.getStudentByEnrollment(enrollmentNo) != null) {
            studentDAO.updateStudentProfile(student);
        } else {
            studentDAO.addStudentProfile(student);
        }

        // Redirect to view the profile
        response.sendRedirect("placementProfile?enrollmentNo=" + enrollmentNo);
    }
    }
    