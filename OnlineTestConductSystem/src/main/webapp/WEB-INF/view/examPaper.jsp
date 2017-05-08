<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>

</head>
<body>

<form:form modelAttribute="newTestQuestion" method="post" enctype="multipart/form-data">
<table>
<tr>
<td>
<form:hidden path="question"  value="${question}"/>

${question.quesName}
</td>
</tr>

<tr>
<td>
<form:label path="slectedOption">Select Option</form:label>
<c:forEach items="${optsList}" var="opt">

<input type="checkbox" value="${opt}"> ${opt.options}
</c:forEach>


</td>

</tr>







	
 <tr><td>	<input type="submit" value="Add"/></td></tr>
</table>			
</form:form>
</body>
</html>