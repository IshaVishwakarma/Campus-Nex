<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="login_student.css">
</head>
<body>

<div class="login-form">
    <h2>Login</h2>
    <!-- Display error message if password is incorrect or ID does not exist -->
    <% if(request.getParameter("error") != null) { %>
        <p class="error-message">${requestScope.errorMessage}</p>
    <% } %>
    <form action="login" method="post">
        <div class="input-group">
            <label for="enrollmentNo">Enrollment No:</label>
            <input type="text" id="enrollmentNo" name="enrollmentNo" required>
        </div>
        <div class="input-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <button type="submit">Login</button>
        <!-- Button to go to registration page -->
        <a href="registration.jsp"><button type="button">Register</button></a>
        <!-- Button to go to home page -->
         <a href="Index.jsp"><button type="button">Home</button></a>
    </form>
</div>

</body>
</html>
