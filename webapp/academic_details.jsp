<%@ page import="com.campusnex.loginuser.User" %>
<%@ page import="com.campusnex.academicdetails.AcademicDetails" %>
<%@ page import="com.campusnex.academicdetails.AcademicDetailsDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
                   
    String enrollmentNo = ((User)session.getAttribute("user")).getEnrollmentNo();
    AcademicDetailsDAO academicDetailsDAO = new AcademicDetailsDAO();
    AcademicDetails academicDetails = academicDetailsDAO.getAcademicDetails(enrollmentNo);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Academic Details</title>
    <link rel="stylesheet" type="text/css" href="academic_details.css">
</head>
<body>
    <h1>Academic Details</h1>
   
    <% String message = (String) request.getAttribute("message");
    if (message != null) { %>
        <p><%= message %></p>
    <% } %>
    <% if (academicDetails != null) { %>
        <p>Enrollment No: <%= academicDetails.getEnrollmentNo() %></p>
        <p>Department: <%= academicDetails.getDepartment() %></p>
        <p>Passing Out Year: <%= academicDetails.getPassingOutYear() %></p>
        <p>Current CGPA: <%= academicDetails.getCurrentCGPA() %></p>
        <p>Marksheet Path: <%= academicDetails.getMarksheetPath() %></p>
        <!-- Add more details here -->
    <% } else { %>
        <p>No data found.</p>
    <% } %>
    <form action="InsertAcademicDetailsServlet" method="post">
        <label for="enrollment_no">Enrollment No:</label><br>
        <input type="text" id="enrollment_no" name="enrollment_no" ><br>
        <label for="department">Department:</label>
        <input type="text" name="department"><br>
        <label for="passingOutYear">Passing Out Year:</label>
        <input type="text" name="passingOutYear"><br>
        <label for="currentCGPA">Current CGPA:</label>
        <input type="text" name="currentCGPA"><br>
        <label for="marksheetPath">Marksheet Path:</label>
        <input type="text" name="marksheetPath"><br>
        <!-- Add more input fields for other details -->
        <input type="submit" value="Save">
    </form>
</body>
</html>
