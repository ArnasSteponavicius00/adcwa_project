<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Error</title>
</head>
<body>
	<h1>Error creating the following Order</h1>
	
	<h3>ERROR: Customer: ${customers.cId} and/or Product: ${products.pId} does not exist</h3>
	
	<a href="/index.html">Home</a>
	<a href="/showCustomers.html">List Customer</a>
	<a href="/showProducts.html">List Products</a>
</body>
</html>