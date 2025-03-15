<%@ page import="com.campusnex.PersonalInfo.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Personal Information</title>
</head>
<body>

<h1>View Personal Information</h1>
<p>Enrollment No: ${student.enrollmentNo}</p>
<p>Name: ${student.name}</p>
<p>Contact No: ${student.contactNo}</p>
<p>Gender: ${student.gender}</p>
<p>Date of Birth: ${student.dob}</p>
<p>Address: ${student.address}</p>
<a href="personalInfo?action=enter">Update Personal Info</a>
</body>
</html>
