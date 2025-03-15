<%@ page import="com.campusnex.PlacementProfile.Student" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Profile</title>
    <link rel="stylesheet" type="text/css" href="view_profile.css">
</head>
<body>
<h1>Student Placement Profile</h1>
<%
    Student student = (Student) request.getAttribute("student");
    if (student != null) {
%>
    <p><strong>Enrollment No:</strong> <%= student.getEnrollmentNo() %></p>
    <p><strong>Domain:</strong> <%= student.getDomain() %></p>
    <p><strong>Resume:</strong> <%= student.getResume() %></p>
    <p><strong>Overall CGPA:</strong> <%= student.getCgpa() %></p>
    <p><strong>Internship:</strong> <%= student.hasInternship() ? "Yes" : "No" %></p>
    <p><strong>Certification:</strong> <%= student.hasCertification() ? "Yes" : "No" %></p>
    <a href="placementProfile?enrollmentNo=<%= student.getEnrollmentNo() %>">Update Profile</a>
<%
    } else {
%>
    <p>No placement profile found for this enrollment number.</p>
<%
    }
%>
</body>
</html>
