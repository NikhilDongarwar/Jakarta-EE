<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>


<meta charset="ISO-8859-1">
<title>Students Details</title>

<style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        form {
            max-width: 400px;
            margin: auto;
        }
        label {
            display: block;
            margin-bottom: 8px;
        }
        input, select {
            width: 100%;
            padding: 8px;
            margin-bottom: 16px;
            box-sizing: border-box;
        }
        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>

</head>
<body>
    <form id="studentForm" action="AddServlet" method="post">
        <label for="studentName">Student Name:</label>
        <input type="text" id="studentName" name="Name" required>

        <label for="studentAddress">Address:</label>
        <input type="text" id="studentAddress" name="Address" required>

        <label for="dataOption">Select Data Source:</label>
        <select id="dataOption" name="dataOption">
            <option value="file">File</option>
            <option value="database">Database</option>
        </select>

        <button type="submit">Submit</button>
        
    </form>




</body>
</html>