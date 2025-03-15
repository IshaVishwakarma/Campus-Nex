<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Dashboard</title>
</head>
<body>
<form action = studentDashboard></form>
    <h1>Welcome to Student Dashboard</h1>
    <c:if test="${empty requestScope.user}">
        <p>User not found or invalid enrollment number.</p>
    </c:if>
    <c:if test="${not empty requestScope.user}">
        <p><strong>Enrollment No.:</strong> ${user.enrollmentNo}</p>
        <p><strong>Name:</strong> ${user.name}</p>
        <p><strong>Email:</strong> ${user.email}</p>
    </c:if>
</body>
</html>
