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
	
	<h3>ERROR: Customer: ${order.cust.cId} and/or Product: ${order.prod.pId} does not exist</h3>
	
	<table>
		<tr>
			<th>Product ID</th>
			<th>Customer ID</th>
			<th>Quantity</th>
		</tr>
		<tr>
			<td>${order.prod.pId}</td>
			<td>${order.cust.cId}</td>
			<td>${order.qty}</td>
		</tr>
	</table>
	
	<a href="/index.html">Home</a>
	<a href="/newOrder.html">New Order</a>
	<a href="/showProducts.html">List Orders</a>
</body>
</html>