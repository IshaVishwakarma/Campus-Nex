<%@ page import="com.campusnex.PlacementProfile.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Enter Profile</title>
    <link rel="stylesheet" type="text/css" href="enetr_profile.css">
</head>
<body>
<h1>Enter Placement Profile</h1>
<form action="placementProfile" method="post">
    <input type="hidden" name="enrollmentNo" value="<%= request.getParameter("enrollmentNo") %>">
    <label for="domain">Domain:</label>
    <input type="text" id="domain" name="domain"><br>
    <label for="resume">Resume:</label>
    <input type="file" id="resume" name="resume"><br>
    <label for="cgpa">Overall CGPA:</label>
    <input type="number" id="cgpa" name="cgpa" step="0.01"><br>
    <label for="internship">Internship:</label>
    <input type="checkbox" id="internship" name="internship" value="yes"><br>
    <label for="certification">Certification:</label>
    <input type="checkbox" id="certification" name="certification" value="yes"><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
