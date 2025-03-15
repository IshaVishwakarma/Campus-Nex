<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Details</title>
    <link rel="stylesheet" type="text/css" href="studentDetails.css">
</head>
<body>
    <div class="container">
        <h1>Student Details</h1>
        <form action="FetchDetailsServletV2" method="post">
            <label for="enrollmentNo">Enrollment No:</label>
            <input type="text" name="enrollmentNo" id="enrollmentNo">
            <br>
            <input type="submit" value="Fetch Details">  
        </form>
    </div>
</body>
</html>
