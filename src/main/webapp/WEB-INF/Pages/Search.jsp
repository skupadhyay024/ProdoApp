<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function validate(){
	
	var a=document.getElementById("se").value;
	var b=document.getElementById("dt").value;
	if(a=="" && b==""){
		document.getElementById("error").innerHTML="No value selected";
		return false;
	}
}




</script>
</head>
<body>
<h1>Search For Order</h1>
<hr>
<form:form method="post" commandName="sform" onsubmit="return validate()">
<table>
<tr>

<td><form:label path="pid">Select Product</form:label></td>
<td><form:select path="pid" items="${cmap }" size="5" multiple="true" id="se"/></td>
</tr>
<tr>
<td><form:label path="pid">Enter Date(dd/MM/yyyy)</form:label></td>

<td><form:input path="ordDate" id="dt"/></td>
</tr>
<tr><td style="color: red;">Note:If you select product and date both it search by date</td></tr>
<div id="error" style="color: red;"></div>
<tr>
<td><input type="submit"/></td>
</tr>
</table>
</form:form>
<c:if test="${plist ne null and not empty plist }">
<table>
<tr>
<th>Order Id</th>
<th>Customer Name</th>
</tr>
<c:forEach items="${ plist}" var="s">
<tr>
<td>${s.oId}</td>
<td>${s.custName}</td>
</tr>
</c:forEach>
</table>
</c:if>
<c:if test="${plist ne null and empty plist }">
No Result Found;


</c:if>
</body>
</html>