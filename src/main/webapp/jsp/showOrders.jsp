<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/style.css" rel="stylesheet">
<title>Show Orders</title>
</head>
<body>
	<h3>List of Orders:</h3>
	<c:forEach items="${orders}" var="order">
		<h3>${order.oId}</h3>
		<table>
			<tr>
				<th>Order ID</th>
				<th>Order Date</th>
				<th>Order Quantity</th>
				<th>Description</th>
				<th>Product ID</th>
				<th>Description</th>
			</tr>
			<tr>
				<td>${order.qty}</td>
				<td>${order.orderDate}</td>
				<td>${order.cust.cId}</td>
				<td>${order.cust.cName}</td>
				<td>${order.prod.pId}</td>
				<td>${order.prod.pDesc}</td>
			</tr>
		</table>
	</c:forEach>
	<a href="/index.html">Home</a>
	<a href="/newOrder.html">Add Order</a>
	<a href="/showProducts.html">List Products</a>
	<a href="/showCustomer.html">List Customers</a>
	<a href="/showCustomers.html">Logout</a>
</body>
</html>