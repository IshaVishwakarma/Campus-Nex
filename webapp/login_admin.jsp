<!DOCTYPE html>
<html>
<head>
    <title>Admin Login</title>
    <link rel="stylesheet" type="text/css" href="login_admin.css">
</head>
<body>

<div class="login-form">
    <h2>Admin Login</h2>
    <!-- Display error message if login fails -->
    <% if(request.getAttribute("errorMessage") != null) { %>
        <p class="error-message">${requestScope.errorMessage}</p>
    <% } %>
    <form action="admin_login" method="post">
        <div class="input-group">
            <label for="adminId">Admin ID:</label>
            <input type="text" id="adminId" name="adminId" required>
        </div>
        <div class="input-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <button type="submit">Login</button>
    </form>
</div>

</body>
</html>
