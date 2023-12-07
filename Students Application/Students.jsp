<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


</body><h2>Student Information Form</h2>

    <form action="StudentServ" method="post">

        <!-- Student Name -->
        <label for="studentName">Name:</label>
        <input type="text" id="studentName" name="Name" required>
        <br>

        <!-- Student Age -->
        <label for="studentAge">Age:</label>
        <input type="number" id="studentAge" name="Age" required>
        <br>

        <!-- Student Address -->
        <label for="studentAddress">Address:</label>
        <textarea id="studentAddress" name="Address"  required></textarea>
        <br>

        <!-- Submit Button -->
        <input type="submit" value="Submit">

    </form>

</html>