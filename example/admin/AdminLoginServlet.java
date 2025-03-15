package com.example.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/admin_login")
public class AdminLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // Hardcoded admin credentials
    private static final Map<String, String> adminCredentials = new HashMap<>();
    static {
        adminCredentials.put("admin1", "password1");
        adminCredentials.put("admin2", "password2");
        adminCredentials.put("admin3", "password3");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String adminId = request.getParameter("adminId");
        String password = request.getParameter("password");

        // Validate admin credentials
        if (!adminCredentials.containsKey(adminId) || !adminCredentials.get(adminId).equals(password)) {
            request.setAttribute("errorMessage", "Incorrect admin ID or password.");
            request.getRequestDispatcher("login_admin.jsp").forward(request, response);
            return;
        }

        // If login successful, redirect to admin dashboard page
        response.sendRedirect("admin_dashboard.jsp");
    }
}
