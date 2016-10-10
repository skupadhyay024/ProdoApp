<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Add Order</h1>
<hr>
<form:form method="post" commandName="pform">
<table>
<tr>
<td>OrderId</td>
<td><form:input path="oId"/></td>
</tr>
<tr>
<td>Customer name</td>
<td><form:input path="custName"/></td>
</tr>
<tr>
<td>Order Date(yyyy-MM-dd)</td>
<td><form:input path="oDate"/></td>
</tr>
<tr>
<td>Products</td>
<td><form:checkboxes items="${catmap }" path="products"/></td>
</tr>
<tr>

<td><input type="submit" name="save"></td>
</tr>
</table>





</form:form>
</body>
</html>