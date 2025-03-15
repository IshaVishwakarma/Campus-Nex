<!DOCTYPE html>
<html>
<head>
    <title>Application Status</title>
</head>
<body>
    <h2>Application Status</h2>
    <% 
        String status = (String)request.getAttribute("status");
        String enrollmentNo = request.getParameter("enrollmentNo");
        String companyName = (String)request.getAttribute("companyName");
        String positionAppliedFor = (String)request.getAttribute("positionAppliedFor");
        
        if(status != null) {
    %>
            <p>Enrollment Number: <%= enrollmentNo %></p>
            <p>Company Name: <%= companyName %></p>
            <p>Position Applied For: <%= positionAppliedFor %></p>
            <p>Status: <%= status %></p>
    <%
        } else {
    %>
            <p>No status found for the given enrollment number.</p>
            <p><a href="updatestatus.jsp?enrollmentNo=<%= enrollmentNo %>">Update Status</a></p>
    <%
        }
    %>
</body>
</html>
