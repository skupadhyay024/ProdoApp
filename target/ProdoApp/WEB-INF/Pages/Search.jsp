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
<form:select path="pid" items="${cmap }" size="5" multiple="true" id="se"/>
<form:input path="ordDate" id="dt"/>
<div id="error" style="color: red;"></div>
<input type="submit"/>

</form:form>
<c:if test="${plist ne null and not empty plist }">
<c:forEach items="${ plist}" var="s">
${s.custName}
</c:forEach>
</c:if>
<c:if test="${plist ne null and empty plist }">
No Result Found;


</c:if>
</body>
</html>