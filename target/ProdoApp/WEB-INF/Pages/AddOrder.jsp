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
OrderId
<form:input path="oId"/><br>
Customer name
<form:input path="custName"/><br>
Order Date
<form:input path="oDate"/><br>
Products
<form:checkboxes items="${catmap }" path="products"/><br>

<input type="submit" name="save">





</form:form>
</body>
</html>