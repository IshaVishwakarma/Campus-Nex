package com.campusnex.application;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateStatus")
public class UpdateStatusServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ApplicationDAO dao;

    @Override
    public void init() throws ServletException {
        super.init();
        dao = new ApplicationDAO();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String enrollmentNo = request.getParameter("enrollmentNo");
       
        String newStatus = request.getParameter("newStatus");
        
        // Update the status in the database
        boolean success = dao.updateApplication(enrollmentNo, newStatus);
        
        if (success) {
            // Redirect back to status.jsp with success message
            response.sendRedirect("status.jsp?enrollmentNo=" + enrollmentNo + "&message=success");
        } else {
            // Handle failure scenario, redirect to an error page or show an error message
            response.sendRedirect("error.jsp");
        }
    }
 }
