 <%@ page import="com.campusnex.studentlist.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Profile</title>
</head>
<body>
    <h2>Student Profile Details</h2>
    <h3>Personal Information</h3>
    <ul>
        <li><strong>Enrollment No:</strong> ${personalProfile.enrollmentNo}</li>
        <li><strong>Name:</strong> ${personalProfile.name}</li>
        <li><strong>Gender:</strong> ${personalProfile.gender}</li>
        <li><strong>Contact No:</strong> ${personalProfile.contactNo}</li>
        <li><strong>Email:</strong> ${personalProfile.email}</li>
    </ul>
    
    <h3>Placement Profile</h3>
    <ul>
        <li><strong>Enrollment No:</strong> ${placementProfile.enrollmentNo}</li>
        <li><strong>Domain:</strong> ${placementProfile.domain}</li>
        <li><strong>CGPA:</strong> ${placementProfile.cgpa}</li>
    </ul>
</body>
</html>
