<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Form</title>
    <link rel="stylesheet" type="text/css" href="student_form.css">
</head>
<body>
    <h1>Enter Student Details</h1>
    <form action="studentProfile" method="post">
        <label for="enrollmentNo">Enrollment No:</label>
        <input type="text" id="enrollmentNo" name="enrollmentNo" required><br>
        
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>
        
        <label for="contactNo">Contact No:</label>
        <input type="text" id="contactNo" name="contactNo" required><br>
        
        <label for="gender">Gender:</label>
        <select id="gender" name="gender" required>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
            <option value="Other">Other</option>
        </select><br>
        
        <label for="dob">Date of Birth:</label>
        <input type="date" id="dob" name="dob" required><br>
        
        <label for="address">Address:</label>
        <textarea id="address" name="address" rows="4" cols="50" required></textarea><br>
        
        <button type="submit">Submit</button>
    </form>
    
    <% if (request.getAttribute("message") != null) { %>
        <p>${message}</p>
    <% } %>
</body>
</html>