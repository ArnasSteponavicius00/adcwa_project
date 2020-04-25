<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Order</title>
</head>
<body>
<h1>Add New Order</h1>
<form:form modelAttribute="order">
  <table>
    <tr>
      <td>Customer:</td>
      <td>
      	<form:select path="cust" items="${customers}"/>
      </td>
    </tr>
    <tr>
      <td>Product:</td>
      <td>
      	<form:select path="prod" items="${products}"/>
      </td>
    </tr>
    <tr>
      <td>Quantity:</td>
      <td>
      	<form:input path="qty"></form:input>
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Add"/>
      </td>
    </tr>
  </table>
</form:form>
</body>
</html>