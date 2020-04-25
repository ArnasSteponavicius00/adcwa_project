<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Orders</title>
</head>
<body>
	<h3>List of Orders:</h3>
	<table>
	  <tr>
	   <th>Order ID</th>
	   <th>Quantity</th>
	   <th>Order Date</th>
	  </tr>
		<tr>
			<c:forEach items="${orders}" var="order">
				<tr>
					<td>${order.oId}</td>
					<td>${order.qty}</td>
					<td>${order.orderDate}</td>
				</tr>
			</c:forEach>
		</tr>
	</table>
</body>
</html>