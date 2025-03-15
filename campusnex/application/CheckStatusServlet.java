package com.campusnex.application;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/checkStatus")
public class CheckStatusServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ApplicationDAO dao;

    @Override
    public void init() throws ServletException {
        super.init();
        dao = new ApplicationDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String enrollmentNo = request.getParameter("enrollmentNo");
        String status = dao.getApplicationStatus(enrollmentNo);
        
        request.setAttribute("status", status);
        request.getRequestDispatcher("status.jsp").forward(request, response);
    }
}