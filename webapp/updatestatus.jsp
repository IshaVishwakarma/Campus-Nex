<%@ page import="com.campusnex.application.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Application Status</title>
</head>
<body>
    <h2>Update Application Status</h2>
    <form action="updateStatus" method="POST">
        <input type="hidden" name="enrollmentNo" value="${param.enrollmentNo}">
        <label for="companyName">Company Name:</label>
        <input type="text" id="companyName" name="companyName"><br>
        <label for="positionAppliedFor">Position Applied For:</label>
        <input type="text" id="positionAppliedFor" name="positionAppliedFor"><br>
        <label for="newStatus">New Status:</label>
        <input type="text" id="newStatus" name="newStatus"><br>
        <button type="submit">Update Status</button>
    </form>
</body>
</html>
