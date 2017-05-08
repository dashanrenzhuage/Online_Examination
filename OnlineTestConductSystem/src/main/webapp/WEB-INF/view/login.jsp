<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<h1> Login Page</h1>

<form action="<spring:url value="/postLogin"></spring:url>" method="post">
	User: <input type="text" id="username" name="username" />
	<br/>
	Password: <input type="password" name='password'/>
	<br/>
	 <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
	 <input type="checkbox" name="keepMe">Remember Me?
	<input type="submit"/>
</form>
</body>
</html>