<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Placement Profile Page</title>
<link rel="stylesheet" type="text/css" href="placement_profile.css">
</head>
<body>
<h1>Placement Profile Page</h1>
<p>Welcome to the Placement Profile Page!</p>
<p>If you already have a placement profile, you can view it by clicking the button below:</p>
<form action="placementProfile" method="get">
    <input type="hidden" name="enrollmentNo" value="enrollmentNo">
    <input type="submit" value="View Profile">
</form>
<p>If you don't have a placement profile yet, you can enter your details now:</p>
<form action="placementProfile" method="post">
    <input type="hidden" name="enrollmentNo" value="enrollmentNo">
    <input type="submit" value="Enter Profile">
</form>
</body>
</html>
