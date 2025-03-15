<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="registration.css">
</head>
<body>

<div class="registration-form">
    <h2>Registration Form</h2>
    <!-- Display error message if enrollment number length is more than 6 characters -->
    <% if(request.getParameter("error") != null && request.getParameter("error").equals("enrollmentLength")) { %>
        <p class="error-message">Enrollment number should not exceed 6 characters.</p>
    <% } %>
    <!-- Display error message if password and confirm password do not match -->
    <% if(request.getParameter("error") != null && request.getParameter("error").equals("passwordMismatch")) { %>
        <p class="error-message">Password and confirm password do not match.</p>
    <% } %>
    <!-- Display error message if enrollment number already exists -->
    <% if(request.getParameter("error") != null && request.getParameter("error").equals("enrollmentExists")) { %>
        <p class="error-message">Enrollment number already exists.</p>
    <% } %>
    <!-- Display success message if data is saved in database -->
    <c:if test="${not empty requestScope.successMessage}">
        <p class="success-message">${requestScope.successMessage}</p>
    </c:if>
    <form action="register" method="post">
        <div class="input-group">
            <label for="enrollmentNo">Enrollment No:</label>
            <input type="text" id="enrollmentNo" name="enrollmentNo" required>
        </div>
        <div class="input-group">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div class="input-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
        </div>
        <div class="input-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div class="input-group">
            <label for="confirmPassword">Confirm Password:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" required>
        </div>
        <button type="submit">Submit</button>
        <!-- Button to go to login page if already registered -->
        <a href="login.jsp"><button type="button">Login</button></a>
    </form>
</div>

</body>
</html>
