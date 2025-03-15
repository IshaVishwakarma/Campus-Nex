<%@ page import="com.campusnex.PersonalInfo.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Enter Personal Information</title>
</head>
<body>

<h1>Enter Personal Information</h1>
<form action="personalInfo" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="${student != null ? student.name : ''}" required><br>
    <label for="contactNo">Contact No:</label>
    <input type="text" id="contactNo" name="contactNo" value="${student != null ? student.contactNo : ''}" required><br>
    <label for="gender">Gender:</label>
    <input type="text" id="gender" name="gender" value="${student != null ? student.gender : ''}" required><br>
    <label for="dob">Date of Birth:</label>
    <input type="text" id="dob" name="dob" value="${student != null ? student.dob : ''}" required><br>
    <label for="address">Address:</label>
    <input type="text" id="address" name="address" value="${student != null ? student.address : ''}" required><br>
    <input type="hidden" name="enrollmentNo" value="<%= request.getSession().getAttribute("enrollmentNo") %>">
    <input type="hidden" name="action" value="${student != null ? 'update' : 'insert'}">
    <input type="submit" value="Submit">
</form>
</body>
</html>

