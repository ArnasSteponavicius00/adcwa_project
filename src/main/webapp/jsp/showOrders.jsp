<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Products</title>
</head>
<body>
	<h1>Added Order: ${order.oId} | ${order.qty} | ${order.orderDate} was added to DB</h1>
	<h3>List of Orders:</h3>
	
	<ol>
		<c:forEach items="${orders}" var="order">
			<li>${order.oId} | ${order.qty} | ${order.orderDate}</li>
		</c:forEach>
	</ol>
</body>
</html>