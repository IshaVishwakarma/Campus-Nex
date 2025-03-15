<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Event</title>
    <link rel="stylesheet" type="text/css" href="createEvent.css">
</head>
<body>
    <div class="container">
        <h1>Create Event</h1>
        <form action="submitEvent.jsp" method="post">
            <div class="form-group">
                <label for="eventName">Event Name:</label>
                <input type="text" name="eventName" id="eventName" required>
            </div>
            <div class="form-group">
                <label for="date">Date:</label>
                <input type="date" name="date" id="date" required>
            </div>
            <div class="form-group">
                <label for="time">Time:</label>
                <input type="time" name="time" id="time" required>
            </div>
            <div class="form-group">
                <label for="venue">Venue:</label>
                <input type="text" name="venue" id="venue" required>
            </div>
            <div class="form-group">
                <label for="about">About the Event:</label>
                <textarea name="about" id="about" rows="4" required></textarea>
            </div>
            <div class="form-group">
                <label for="departments">Departments:</label>
                <select name="departments" id="departments" multiple required>
                    <option value="IT">IT</option>
                    <option value="CS">CS</option>
                    <option value="ECE">ECE</option>
                    <option value="EE">EE</option>
                </select>
            </div>
            <div class="form-group">
                <label for="passingYears">Passing Out Years:</label>
                <select name="passingYears" id="passingYears" multiple required>
                    <option value="2022">2022</option>
                    <option value="2023">2023</option>
                    <option value="2024">2024</option>
                    <option value="2025">2025</option>
                </select>
            </div>
            <input type="submit" value="Create Event">
        </form>
    </div>
</body>
</html>
