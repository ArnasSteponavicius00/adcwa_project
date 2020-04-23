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
	<h1>Added Product: ${product.pDesc} | ${product.qtyInStock} was added to DB</h1>
	<h3>List of Products:</h3>
	
	<ol>
		<c:forEach items="${products}" var="product">
			<li>${product.pDesc} | ${product.qtyInStock}</li>
		</c:forEach>
	</ol>
</body>
</html>