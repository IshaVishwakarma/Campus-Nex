package com.campusnex.academicdetails;
import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class UpdateAcademicDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String enrollmentNo = (String) request.getSession().getAttribute("enrollment_no");
        String department = request.getParameter("department");
        int passingOutYear = Integer.parseInt(request.getParameter("passingOutYear"));
        double currentCGPA = Double.parseDouble(request.getParameter("currentCGPA"));
        String marksheetPath = request.getParameter("marksheetPath");

        AcademicDetails academicDetails = new AcademicDetails();
        academicDetails.setEnrollmentNo(enrollmentNo);
        academicDetails.setDepartment(department);
        academicDetails.setPassingOutYear(passingOutYear);
        academicDetails.setCurrentCGPA(currentCGPA);
        academicDetails.setMarksheetPath(marksheetPath);

        AcademicDetailsDAO academicDetailsDAO = null;
        try {
            academicDetailsDAO = new AcademicDetailsDAO();
            academicDetailsDAO.updateAcademicDetails(academicDetails);
            response.sendRedirect("AcademicDetails.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database error
        }
    }
}
