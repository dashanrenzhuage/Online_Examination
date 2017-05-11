<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<title>Insert title here</title>
<style>

tr {

display: none
}






</style>

</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript">

/* window.onload = function() {
	$(' tr').fadeOut();
}  */


var i = 1;
var j = 2;
	function myFunction() {
	
		$("#start").hide();
		 $("table tr:nth-child( "+i+")").fadeOut();
		 
		$("table tr:nth-child("+j+ ")").fadeIn(); 
		i++;
		j++;
		/* alert(i); */
		
	 
	}
	</script>
<body>

	<form:form modelAttribute="newAnswer" method="post"
		enctype="multipart/form-data">


		<input id="start" type="button" onclick="myFunction(0)" value="Start">
		<table class="allTable">
		<tr>
		
		</tr>
		
			<c:forEach items="${questionsList}" varStatus="ans">
		
	<tr>
			<form:hidden path="answerList[${ans.index}].question.id" value="${questionsList[ans.index].id}" />
			
					<td><c:out value="${questionsList[ans.index].quesName}"></c:out>
						
						
						<form:select path="answerList[${ans.index}].selectedOpt.id"
							items="${questionsList[ans.index].opts}" itemValue="id"
							itemLabel="options"></form:select>
			
							<input id="next" type="button" onclick="myFunction()" value="next"></td>
	
				</tr>
			</c:forEach>
		</table>

		<%-- <tr>
				<c
				:forEach items="${question.opts}" varStatus="vs">
					<div class="row">

						<form:input type="text" path="opts[${vs.index}].options"
							class="form-control" id="option" name="question"
							placeholder="Enter option here" />
						<form:checkbox path="opts[${vs.index}].isCorrectAns"
							id="checkbox_ans" name="checkbox_ans"></form:checkbox>
					</div>
					</div>
				</c:forEach>
			</tr> --%>
		<%-- 	<tr>
		
		***********Correct for one answer***********
				<td>${questions.quesName}</td>
			</tr>
			 <tr>
				<td>Answer:</td>
				<td><form:select id="selectedOpt" path="selectedOpt.id"
						items="${questions.opts}" itemValue="id" itemLabel="options" /></td>
			</tr> --%>

		<tr>

		</tr>
		<tr>

			<%-- <c:forEach items="${questions.opts}" varStatus="quest">

					<td><form:radiobutton path="selectedOpt.id"
							value="${questions.opts[quest.index]}" label="opt" /> <c:out
							value="${questions.opts[quest.index].options}" ></c:out>
				</c:forEach>

			</tr> --%>


			<%-- <tr>
				<td><c:forEach items="${option }" var="opt">

						<form:checkbox path="selectedOpt.id" value="${opt }"
							itemValue="id" itemLabel="options" />${opt.options}
			</c:forEach></td>
			</tr> --%>
		<tr>
			<td><input type="submit" value="Submit" /></td>
		</tr>
		<tr>

			<%-- <form:hidden path="answerList" items="${answerList }" /> --%>
	</form:form>
</body>
</html>