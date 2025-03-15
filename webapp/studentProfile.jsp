<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Profile</title>
    <link rel="stylesheet" type="text/css" href="student_profile.css">
</head>
<body>
    <h1>Student Profile</h1>
    
    <form action="studentProfile" method="get">
        <label for="enrollmentNo">Enter Enrollment No:</label>
        <input type="text" id="enrollmentNo" name="enrollmentNo" required>
        <button type="submit">Submit</button>
    </form>

    <c:choose>
        <c:when test="${not empty student}">
            <p>Enrollment No: ${student.enrollmentNo}</p>
            <p>Name: ${student.name}</p>
            <p>Contact No: ${student.contactNo}</p>
            <p>Gender: ${student.gender}</p>
            <p>Date of Birth: ${student.dob}</p>
            <p>Address: ${student.address}</p>
            <a href="studentForm.jsp?enrollmentNo=${student.enrollmentNo}">Update Profile</a>
        </c:when>
        <c:otherwise>
            <p>Student data not found.</p>
            <a href="studentForm.jsp">Enter Student Data</a>
        </c:otherwise>
    </c:choose>
</body>
</html>
