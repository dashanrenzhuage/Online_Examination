<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap -->
<link
	href="<c:url value = '/resources/css/bootstrap/dist/css/bootstrap.min.css'></c:url>"
	rel="stylesheet">
<!-- Font Awesome -->
<link
	href="<c:url value = '/resources/fonts/font-awesome/css/font-awesome.min.css'></c:url>"
	rel="stylesheet">

<!-- NProgress -->
<link
	href="<c:url value = '/resources/js/nprogress/nprogress.css'></c:url>"
	rel="stylesheet">

<!-- Custom Theme Style -->
<link href="<c:url value = '/resources/css/custom.min.css'></c:url>"
	rel="stylesheet">
<link href="<c:url value = '/resources/css/student.css'></c:url>"
	rel="stylesheet">

<script
	src='<spring:url value="/resources/js/jquery-3.2.1.js"></spring:url>'></script>

<%-- <script
	src='<spring:url value="/resources/js/categoryAndSubCategorySelection.js" ></spring:url>'></script> --%> 
	
<style>
tr {
	display: none
}
</style>

<script type="text/javascript">

/* window.onload = function() {
	$(' tr').fadeOut();
}  */


var i = 1;
var j = 2;
	function myFunction() {
	
		
		 $("table tr:nth-child( "+i+")").fadeOut();
		 
		$("table tr:nth-child("+j+ ")").fadeIn(); 
		i++;
		j++;
		//alert(i);
		
	 
	}
</script>

<title>MUM Online Test Conduct System</title>
</head>
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">
					<div class="navbar nav_title" style="border: 0;">
						<a href="stu_sel_exam.html" class="site_title"><i
							class="fa fa-user"></i> <span>Student</span></a>
					</div>

					<div class="clearfix"></div>

					<!-- menu profile quick info -->
					<div class="profile clearfix">
						<div class="profile_pic">
							<img
								src='<spring:url value="/resources/images/img.jpg"></spring:url>'
								alt="..." class="img-circle profile_img">
						</div>
						<div class="profile_info">
							<span>Welcome,</span>
							<h2>John Doe</h2>
						</div>
					</div>
					<!-- /menu profile quick info -->

					<br />

					<!-- sidebar menu -->
					<div id="sidebar-menu"
						class="main_menu_side hidden-print main_menu">
						<div class="menu_section">
							<h3>General</h3>
							<ul class="nav side-menu">
								<li><a><i class="fa fa-home"></i> Home <span
										class="fa fa-chevron-down"></span></a></li>
							</ul>
						</div>

					</div>
					<!-- /sidebar menu -->

					<!-- /menu footer buttons -->
					<div class="sidebar-footer hidden-small">
						<a data-toggle="tooltip" data-placement="top" title="Settings">
							<span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="FullScreen">
							<span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="Lock"> <span
							class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="Logout"
							href="login.html"> <span class="glyphicon glyphicon-off"
							aria-hidden="true"></span>
						</a>
					</div>
					<!-- /menu footer buttons -->
				</div>
			</div>

			<!-- top navigation -->
			<div class="top_nav">
				<div class="nav_menu">
					<nav>
					<div class="nav toggle">
						<a id="menu_toggle"><i class="fa fa-bars"></i></a>
					</div>

					<ul class="nav navbar-nav navbar-right">
						<li class=""><a href="javascript:;"
							class="user-profile dropdown-toggle" data-toggle="dropdown"
							aria-expanded="false"> <img
								src='<spring:url value="/resources/images/img.jpg"></spring:url>'
								alt="">John Doe <span class=" fa fa-angle-down"></span>
						</a>
							<ul class="dropdown-menu dropdown-usermenu pull-right">
								<li><a href="javascript:;"> Profile</a></li>
								<li><a href="javascript:;"> <span
										class="badge bg-red pull-right">50%</span> <span>Settings</span>
								</a></li>
								<li><a href="javascript:;">Help</a></li>
								<li><a href="login.html"><i
										class="fa fa-sign-out pull-right"></i> Log Out</a></li>
							</ul></li>

						<li role="presentation" class="dropdown"><a
							href="javascript:;" class="dropdown-toggle info-number"
							data-toggle="dropdown" aria-expanded="false"> <i
								class="fa fa-envelope-o"></i> <span class="badge bg-green">6</span>
						</a>
							<ul id="menu1" class="dropdown-menu list-unstyled msg_list"
								role="menu">
								<li><a> <span class="image"><img
											src="images/img.jpg" alt="Profile Image" /></span> <span> <span>John
												Smith</span> <span class="time">3 mins ago</span>
									</span> <span class="message"> Film festivals used to be
											do-or-die moments for movie makers. They were where... </span>
								</a></li>
								<li><a> <span class="image"><img
											src="images/img.jpg" alt="Profile Image" /></span> <span> <span>John
												Smith</span> <span class="time">3 mins ago</span>
									</span> <span class="message"> Film festivals used to be
											do-or-die moments for movie makers. They were where... </span>
								</a></li>
								<li><a> <span class="image"><img
											src="images/img.jpg" alt="Profile Image" /></span> <span> <span>John
												Smith</span> <span class="time">3 mins ago</span>
									</span> <span class="message"> Film festivals used to be
											do-or-die moments for movie makers. They were where... </span>
								</a></li>
								<li><a> <span class="image"><img
											src="images/img.jpg" alt="Profile Image" /></span> <span> <span>John
												Smith</span> <span class="time">3 mins ago</span>
									</span> <span class="message"> Film festivals used to be
											do-or-die moments for movie makers. They were where... </span>
								</a></li>
								<li>
									<div class="text-center">
										<a> <strong>See All Alerts</strong> <i
											class="fa fa-angle-right"></i>
										</a>
									</div>
								</li>
							</ul></li>
					</ul>
					</nav>
				</div>
			</div>
			<!-- /top navigation -->

			<!-- page content -->
			<div class="right_col" role="main">
				<form:form modelAttribute="newAnswer" method="post"
					enctype="multipart/form-data">
					
					<div class="form-group">
						<div class="row">
							<div class="col-sm-1"></div>
							<div class="col-sm-11">
								<input id="next" type="button" onclick="myFunction(0)" value="next">
							</div>
						</div>
					</div>
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
						<td><input type="submit" value="Add" /></td>
					</tr>
					<tr>
			
						<%-- <form:hidden path="answerList" items="${answerList }" /> --%>
				</form:form>
			</div>
			<!-- /page content -->

			<!-- footer content -->
			<footer>
			<div class="pull-right">&copy; 2017 Maharishi University of
				Management. All rights reserved.</div>
			<div class="clearfix"></div>
			</footer>
			<!-- /footer content -->
		</div>
	</div>


	<!-- jQuery -->
	<script
		src='<spring:url value="/resources/js/jquery/dist/jquery.min.js"></spring:url>'></script>
	<!-- Bootstrap -->
	<script
		src='<spring:url value="/resources/css/bootstrap/dist/js/bootstrap.min.js"></spring:url>'></script>
	<!-- FastClick -->
	<script
		src='<spring:url value="/resources/js/fastclick/lib/fastclick.js"></spring:url>'></script>
	<!-- NProgress -->
	<script
		src='<spring:url value="/resources/js/nprogress/nprogress.js"></spring:url>'></script>

	<!-- Custom Theme Scripts -->
	<script
		src='<spring:url value="/resources/js/custom.min.js"></spring:url>'></script>
</body>
</html>