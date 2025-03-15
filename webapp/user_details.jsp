<%@ page import="com.campusnex.loginuser.User" %>

<!DOCTYPE html>
<html>
<head>
    <title>Student Dashboard</title>
    <link rel="stylesheet" type="text/css" href="user_details.css">
</head>
<body>
    <!-- Sidebar -->
    <div class="sidebar">
        <!-- User Details -->
        <h2>User Details</h2>
        <p>Enrollment No: <%= ((User)session.getAttribute("user")).getEnrollmentNo() %></p>
        <p>Name: <%= ((User)session.getAttribute("user")).getName() %></p>
        <p>Email: <%= ((User)session.getAttribute("user")).getEmail() %></p>
        <!-- Navigation Links -->
        <h2>Navigation</h2>
        <ul>
            <li><a href="academic_details.jsp">Academic Details</a></li>
            <li><a href="placement_profile.jsp">Placement Profile</a></li>
            <li><a href="studentProfile.jsp">Personal Information</a></li>
            <li><a href="help.jsp">Help</a></li>
            <li><a href="application_status.jsp">Application Status</a></li>
            <li><a href="upcoming_events.jsp">Upcoming Events</a></li>
        </ul>
        <!-- Logout Button -->
        <form action="Index.jsp" method="post">
            <input type="submit" value="Logout">
        </form>
    </div>

    <!-- Content -->
    <div class="content">
        <!-- Academic Details Section -->
        <div class="section">
            <h2>Academic Details</h2>
            <p>This section will display academic details. Include academic_details.jsp here.</p>
        </div>
        
        <!-- Placement Profile Section -->
        <div class="section">
            <h2>Placement Profile</h2>
            <p>This section will display placement profile. Include placement_profile.jsp here.</p>
        </div>
        
        <!-- Personal Information Section -->
        <div class="section">
            <h2>Personal Information</h2>
            <p>This section will display personal information. Include personal_information.jsp here.</p>
        </div>
        
        <!-- Help Section -->
        <div class="section">
            <h2>Help</h2>
            <p>This section will provide help. Include help.jsp here.</p>
        </div>
        
        <!-- Application Status Section -->
        <div class="section">
            <h2>Application Status</h2>
            <p>This section will display application status. Include application_status.jsp here.</p>
        </div>
        
        <!-- Upcoming Events Section -->
        <div class="section">
            <h2>Upcoming Events</h2>
            <p>This section will display upcoming events. Include upcoming_events.jsp here.</p>
        </div>
    </div>
</body>
</html>
