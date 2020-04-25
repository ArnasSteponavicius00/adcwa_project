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
	<h3>List of Customers:</h3>
	<c:forEach items="${customers}" 
	                 var="customer">      
		<h3>${customer.cId} | ${customer.cName}</h3>
		<table>
		  	<tr>
	    		<th>Order ID</th>
	    		<th>Order Quantity</th>
	    		<th>Order Date</th>
	    		<th>Description</th>
	  		</tr>
	  		<c:forEach items="${customer.orders}" var="order">
	  			<tr>
	  				<td>${order.oId}</td>
	  				<td>${order.qty}</td>
	  				<td>${order.orderDate}</td>
	  				<td>${order.prod.pDesc}</td>
	  			</tr>
	  		</c:forEach>
	  	</table>
	  </c:forEach>
</body>
</html>