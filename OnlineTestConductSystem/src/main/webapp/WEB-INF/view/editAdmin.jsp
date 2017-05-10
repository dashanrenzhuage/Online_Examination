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
<link href="<c:url value = '/resources/css/admin.css'></c:url>"
	rel="stylesheet">



<title>MUM Online Test Conduct System</title>
</head>
<body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="admin_addcoach.html" class="site_title"><i class="fa fa-user"></i> <span>Administrator</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile clearfix">
              <div class="profile_pic">
                <img src='<spring:url value="/resources/images/img.jpg"></spring:url>' alt="..." class="img-circle profile_img">
              </div>
              <div class="profile_info">
                <span>Welcome,</span>
                <h2>John Doe</h2>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />

          <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                  <li><a><i class="fa fa-home"></i> Coach <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li>
                      <a href="<spring:url value="/employee/add" />"
							>Add Coach</a></li>
					  <li><a href="<spring:url value="/employee/listCoach" />"
							>List Of Coach</a></li></li>
                    </ul>
                  </li>
				  <li><a><i class="fa fa-home"></i> Administrator <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li>
                      <a href="<spring:url value="/employee/addAdmin" />"
							>Add Admin</a></li>
					  <li><a href="<spring:url value="/employee/listAdmin" />"
							>List Of Admin</a></li></li>
                    </ul>
                  </li>
                  
                  <li><a><i class="fa fa-home"></i> Data Admin <span class="fa fa-chevron-down"></span></a>
                   <ul class="nav child_menu">
                      <li>
                      <a href="<spring:url value="/employee/addDataAdmin" />"
							>Add Data Admin</a></li>
					  <li><a href="<spring:url value="/employee/listDataAdmin" />"
							>List Of Data Admin</a></li></li>
                    </ul>
                  </li>
                  
                  <li><a><i class="fa fa-home"></i> Student <span class="fa fa-chevron-down"></span></a>
                   <ul class="nav child_menu">
                      <li>
                      <a href="<spring:url value="/students/addStudent" />"
							>Add Studnet</a></li>
					  <li><a href="<spring:url value="/students/listStudent" />"
							>List Of Student</a></li></li>
                    </ul>
                  </li>


                   <li><a><i class="fa fa-home"></i> Add Category & Sub Category <span class="fa fa-chevron-down"></span></a>
                   <ul class="nav child_menu">
                      <li>
                      <a href="<spring:url value="/category/add" />"
							>Add Category</a></li>
					  <li><a href="<spring:url value="/subcategories/add" />"
							>Add Sub-Category</a></li></li>

                </ul>
              </div>

            </div>
            <!-- /sidebar menu -->
            <!-- /menu footer buttons -->
            <div class="sidebar-footer hidden-small">
              <a data-toggle="tooltip" data-placement="top" title="Settings">
                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Lock">
                <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Logout" href="login.html">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
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
                <li class="">
                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    <img
						src='<spring:url value="/resources/images/img.jpg"></spring:url>'
						alt="...">John Doe
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right">
                    <li><a href="javascript:;"> Profile</a></li>
                    <li>
                      <a href="javascript:;">
                        <span class="badge bg-red pull-right">50%</span>
                        <span>Settings</span>
                      </a>
                    </li>
                    <li><a href="javascript:;">Help</a></li>
                    <li><a href="login.html"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                  </ul>
                </li>

                <li role="presentation" class="dropdown">
                  <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
                    <i class="fa fa-envelope-o"></i>
                    <span class="badge bg-green">6</span>
                  </a>
                  <ul id="menu1" class="dropdown-menu list-unstyled msg_list" role="menu">
                    <li>
                      <a>
                        <span class="image"><img
						src='<spring:url value="/resources/images/img.jpg"></spring:url>'
						alt="..."></span>
                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                        <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                      </a>
                    </li>
                    <li>
                      <a>
                        <span class="image"><img
						src='<spring:url value="/resources/images/img.jpg"></spring:url>'
						alt="..."></span>
                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                        <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                      </a>
                    </li>
                    <li>
                      <a>
                        <span class="image"><img
						src='<spring:url value="/resources/images/img.jpg"></spring:url>'
						alt="..."></span>
                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                        <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                      </a>
                    </li>
                    <li>
                      <a>
                        <span class="image"><img
						src='<spring:url value="/resources/images/img.jpg"></spring:url>'
						alt="..."></span>
                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                        <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                      </a>
                    </li>
                    <li>
                      <div class="text-center">
                        <a>
                          <strong>See All Alerts</strong>
                          <i class="fa fa-angle-right"></i>
                        </a>
                      </div>
                    </li>
                  </ul>
                </li>
              </ul>
            </nav>
          </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
        <form:form modelAttribute="employee" method="post" enctype="multipart/form-data">
			<%-- <form action="add" method="post"> --%>
			    <div id="addadmin" class="form-group center-align">
					<h4>Edit Administrator<h4>
				</div>
			    <div id="fName" class="form-group">
					<div class="row">
						<div class="col-sm-1"></div>
						<div class="col-sm-1">
							<label for="to" class="lab">First Name:</label>
						</div>
						<div class="col-sm-9">
							<!-- <input type="text" class="form-control" id="cn" name="cn"/> -->
							<form:input id="fName" class="form-control" name="fName" path="fName" type="text" />
						</div>
					</div>
				</div>
				<div id="lName" class="form-group">
					<div class="row">
						<div class="col-sm-1"></div>
						<div class="col-sm-1">
							<label for="to" class="lab">Last Name:</label>
						</div>
						<div class="col-sm-9">
							<!-- <input type="text" class="form-control" id="cn" name="cn"/> -->
							<form:input id="lName" class="form-control" name="lName" path="lName" type="text" />
						</div>
					</div>
				</div>
				
				<div id="username" class="form-group">
					<div class="row">
						<div class="col-sm-1"></div>
						<div class="col-sm-1">
							<label for="message" class="lab">Username:</label>
						</div>
						<div class="col-sm-9">
							<form:input id="credential.username" class="form-control" name="credential.username" path="credential.username" type="text" /> 
						</div>
					</div>
				</div>
				<div id="password" class="form-group">
					<div class="row">
						<div class="col-sm-1"></div>
						<div class="col-sm-1">
							<label for="message" class="lab">Password:</label>
						</div>
						<div class="col-sm-9">
							<form:input id="credential.password" class="form-control" name="credential.password" path="credential.password" type="password" />
						</div>
					</div>
				</div>
				<div id="role" class="form-group">
					<div class="row">
						<div class="col-sm-1"></div>
						<div class="col-sm-1">
							<!-- <label for="message" class="lab">Role:</label> -->
						</div>
						<div class="col-sm-9">
						<%-- <form:input id="credential.role" name="credential.role" path="credential.role" type="role" value = "ADMIN" /> --%>
							<form:hidden path="credential.role" value = "ADMIN"/>
						</div>
					</div>
				</div>
				<div>
					<div class="row">
					    <div class="col-sm-10"></div>
						<div class="col-sm-1">
							<button type="submit" id="submit" class="btn">Add</button>
						</div>
						<div class="col-sm-1"></div>
					</div>
				</div>
				</form:form>
			</div>
        <!-- /page content -->

        <!-- footer content -->
        <footer>
          <div class="pull-right">
              &copy; 2017 Maharishi University of Management. All rights reserved.
          </div>
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
	<%-- <script
		src='<spring:url value="/resources/js/jquery.dataTables.min.js"></spring:url>'></script>
	<script
		src='<spring:url value="/resources/js/dataTables.bootstrap.min.js"></spring:url>'></script>
	<script
		src='<spring:url value="/resources/js/data_table.js"></spring:url>'></script>
 --%>

</body>
</html>