package com.campusnex.academicdetails;
import java.io.IOException;
import java.sql.SQLException;

import com.campusnex.academicdetails.AcademicDetails;
import com.campusnex.academicdetails.AcademicDetailsDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertAcademicDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve parameters from the request
        String enrollmentNo = request.getParameter("enrollment_no"); // Assuming enrollmentNo is provided in the form

        String department = request.getParameter("department");
        int passingOutYear = Integer.parseInt(request.getParameter("passingOutYear"));
        double currentCGPA = Double.parseDouble(request.getParameter("currentCGPA"));
        String marksheetPath = request.getParameter("marksheetPath");

        // Create an AcademicDetails object
        AcademicDetails academicDetails = new AcademicDetails();
        academicDetails.setEnrollmentNo(enrollmentNo);
        academicDetails.setDepartment(department);
        academicDetails.setPassingOutYear(passingOutYear);
        academicDetails.setCurrentCGPA(currentCGPA);
        academicDetails.setMarksheetPath(marksheetPath);

        // Instantiate AcademicDetailsDAO
        AcademicDetailsDAO academicDetailsDAO = null;
        String message;
        try {
            academicDetailsDAO = new AcademicDetailsDAO();
            academicDetailsDAO.insertAcademicDetails(academicDetails);
            message = "Academic details inserted successfully!";
        } catch (SQLException e) {
            e.printStackTrace();
            
            message = "Failed to insert academic details. Please try again later." +e.getMessage();
            System.out.print(message);
        }

        // Set the message as an attribute and forward the request
        request.setAttribute("message", message);
        request.getRequestDispatcher("academic_details.jsp").forward(request, response);
    }
}
