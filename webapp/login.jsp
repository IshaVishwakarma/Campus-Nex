<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="login.css">
</head>
<body>
    <h2>Login</h2>
    <form action="login" method="post">
        <label for="enrollment_no">Enrollment No:</label><br>
        <input type="text" id="enrollment_no" name="enrollment_no" required><br>
        <label for="password">Password:</label><br>
        <input type="password" id="password" name="password" required><br><br>
        <input type="submit" value="Login">
        <% if (request.getParameter("error") != null) { %>
            <p class="error-message">Invalid credentials. Please try again.</p>
        <% } %>
    </form>
    <div class="buttons-container">
        <button onclick="window.location.href='registration.jsp'">Register</button>
        <button onclick="window.location.href='home.html'">Home</button>
    </div>
</body>
</html>

