package com.campusnex.studentlist;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/StudentProfileServlet")
public class StudentProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDAO studentDAO;

    public void init() {
        studentDAO = new StudentDAOImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String enrollmentNo = request.getParameter("enrollmentNo");

        // Retrieve personal profile
        PersonalProfile personalProfile = studentDAO.getPersonalProfile(enrollmentNo);
        // Retrieve placement profile
        PlacementProfile placementProfile = studentDAO.getPlacementProfile(enrollmentNo);

        // Set attributes in request scope
        request.setAttribute("personalProfile", personalProfile);
        request.setAttribute("placementProfile", placementProfile);

        // Forward to JSP to display profiles
        request.getRequestDispatcher("studentProfile.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
