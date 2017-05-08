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

<form:form modelAttribute="newQuestion" method="post" enctype="multipart/form-data">
<table>

<tr><td>Category:</td><td><form:select id="category" path="category"
items="${categories}" itemValue="name" itemLabel="name" /></td>

	<script>
	$('#category').change(function(){
	var selectedCat = $('#category').val();
	$('#subCategories').each(function(){
		 $('subCatSel').append( '<option>' + $(this) + '</option>' );
		 alert($(this));
	});
	
	});
	
	
	
	</script>
</tr>

<tr>
<c:forEach items="${categories }" var ="subCat">

<form:checkboxes items="${subCat.subcategories}" path="subCategory"/>



</c:forEach>
</tr>

<tr><td>Subcategory:</td><td><form:select id="subCategory" path="subCategory"
items="${subCategories}" itemValue="subCatName" itemLabel="subCatName" /></td>


</tr>

<tr><td>Question :</td><td><form:input id="quesName" name="quesName" path="quesName" type="text"  /></td>
		
</tr>
			




	
 <tr><td>	<input type="submit" value="Add"/></td></tr>
</table>			
</form:form>
</body>
</html>