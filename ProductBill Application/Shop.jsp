<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="SecondServ" method="post">
<c:forEach var="str" items="${requestScope.tada}">
	<input type=checkbox name=ch value=${str}>${str}
</c:forEach>
<input type=submit>
</form>

</body>
</html>