<!DOCTYPE html>
<html>
<head>
    <title>Help Section</title>
</head>
<body>
    <h2>Help Section</h2>
    <h3>Student Help</h3>
    <form action="StudentHelpServlet" method="post">
        <label for="studentMessage">Message:</label><br>
        <textarea id="studentMessage" name="studentMessage" rows="4" cols="50"></textarea><br><br>
        <input type="submit" value="Send">
    </form>
    
    <hr>
    
    <h3>Admin Help</h3>
    <h4>View Messages</h4>
    <ul>
        <c:forEach var="message" items="${adminMessages}">
            <li>${message}</li>
        </c:forEach>
    </ul>
</body>
</html>
