<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Customers</title>
</head>
<body>
	<h1>Customer: ${customer.cName} was added to DB</h1>
	<h3>List of Customers:</h3>
	
	<ol>
		<c:forEach items="${customers}" var="customer">
			<li>${customer.cName}</li>
		</c:forEach>
	</ol>
</body>
</html>