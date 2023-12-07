<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
  table {
    border-collapse: collapse;
    width: 100%;
  }

  td {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
  }

  tr:nth-child(even) {
    background-color: #f2f2f2;
  }

  tr:hover {
    background-color: #ddd;
  }
</style>

</head>
<body>
<table border="1">

<c:forEach var="myval" items="${sessionScope.Proc}">
<tr>
<td>
${myval}
</td>
</tr>
	</c:forEach>
</body>
</html>