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
</head>
<body>

<form:form modelAttribute="newAdmin" method="post" enctype="multipart/form-data">
<table>


		
<tr><td>First Name:</td><td><form:input id="fName" name="fName" path="fName" type="text" /></td>
		<td><form:errors path="fName" cssStyle="color:red;"/></td>
</tr>
			
<tr><td>Last Name:</td><td><form:input id="lName" name="lName" path="lName" type="text"/></td>
			<td><form:errors path="lName" cssStyle="color:red;"/></td>
</tr>


<tr><td>username:</td><td><form:input id="credential.username" name="credential.username" path="credential.username" type="text" /> </td>
		<td>	<form:errors path="credential.username" cssStyle="color:red;"/></td>
		</tr>

<tr><td>password:</td><td><form:input id="credential.password" name="credential.password" path="credential.password" type="password" /> </td>
		</tr>		


<%-- 	<tr><td>
Image:		<label for="productImage"></label></td>
			<form:input id="productImage" path="productImage" type="file"/>
 --%>		
 <tr><td>	<input type="submit" value="Add"/></td></tr>
</table>			
</form:form>
</body>
</html>