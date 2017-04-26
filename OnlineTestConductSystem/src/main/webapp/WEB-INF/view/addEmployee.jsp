<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
<title>User Sign Up</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  
<body>

<form:form modelAttribute="employee" method="post">
<table>
<div class="form-group">
	<tr> 
	<td><%-- <spring:message code="employee.username" /> --%>UserName: </td> 
	<td> <form:input path="credential.username"  type="text" class="form-control"/></td>
	
	</tr>
	

	
	<tr>
	<td><%-- <spring:message code="employee.password" /> --%>Password:</td>
	<td><form:input path="credential.password"  type="password" class="form-control"/></td>
	
	</tr>

</div>
</table>
<form:hidden path="credential.enabled" value="true"/>
<input type="submit" value="AddEmployee">
</form:form>
</body>
</html>