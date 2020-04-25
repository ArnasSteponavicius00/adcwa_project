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
		<c:forEach items="${orders}" 
	                 var="order">      
		<h3>${order.oId}</h3>
		<table>
		  	<tr>
	    		<th>Order ID</th>
	    		<th>Order Quantity</th>
	    		<th>Order Date</th>
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
</body>
</html>