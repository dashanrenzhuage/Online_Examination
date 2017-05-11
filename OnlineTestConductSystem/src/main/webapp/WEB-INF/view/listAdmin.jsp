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
                <h2>${pageContext.request.userPrincipal.name}</h2>
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
						alt="...">${pageContext.request.userPrincipal.name}
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
                    <li> <a href="<spring:url value="/employee/logout" />"
							><i class="fa fa-sign-out pull-right"></i>Log Out </a></li>
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
        	<div id="addadmin" class="form-group center-align">
				<h4>List of Administrators<h4>
			</div>
			<c:if test="${not empty adminDeleteMessage}">
				<script>
					setTimeout(function() {
						$('#adminDeleteMessage').fadeOut('medium');
					}, 2000);
				</script>
				<div id="adminDeleteMessage"
					class="alert alert-danger alert-dismissable">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
					<strong>Success!</strong> You have successfully deleted administrator.
				</div>
			</c:if>
			<div id="categoryList">
					<div class="row">
						<div class="col-sm-1"></div>
						<div class="col-sm-10">
							<table id="example" class="table table-hover">
								<thead>
									<tr>
										<th width="20%">First Name</th>
										<th width="20%">Last Name</th>
										<th width="20%">Username</th>
										<th width="20%">Password</th>
										<th width="20%">Edit</th>
										<th width="20%">Delete</th>
									</tr>
								</thead>
								<tbody>
								
								
								<c:forEach items="${adminList}" var="admin">

										<tr>
											<td id="hehe">${admin.fName}</td>
											<%-- <td>${coach.fName}</td> --%>
											<td>${admin.lName}</td>
											<%-- <td>${coach.email}</td> --%>
											<td>${admin.credential.username}</td>
											<td>${admin.credential.password}</td>
											<td><a
												href="<spring:url value="/employee/addAdmin/${admin.id}" />">Edit</a></td>

												<!-- <td><a href="<spring:url value="/employee/deleteAdmin/${admin.id}" />"
												<%-- <td><a href="<spring:url value="/employee/delete/${admin.id}" />" --%>
																	class="btn btn-info" role="button">Delete</a></td>  -->
												<td>
													<a data-toggle="modal" data-target="#myModal"
																			class="btn btn-info" role="button">Delete</a></td>
														<!-- <button type="button" class="btn btn-info btn-lg"
															data-toggle="modal" data-target="#myModal" style="margin:0px;">Send
															Access ID</button> --> <!-- Modal -->
														<div class="modal fade" id="myModal" role="dialog">
															<div class="modal-dialog">
					
																<!-- Modal content-->
																<div class="modal-content">
																	<div class="modal-header">
																		<button type="button" class="close" data-dismiss="modal">&times;</button>
																		<h4 class="modal-title">
																			<b>Delete Administrator</b>
																		</h4>
																	</div>
																	<div class="modal-body">
																		<p>Are you sure you want to delete administrator?</p>
																	</div>
																	<div class="modal-footer">
																		<a href="<spring:url value="deleteAdmin/${admin.id}" />"
																			class="btn btn-info" role="button">Delete</a>
																	</div>
																</div>
															</div>
														</div>

											<!--Delete Coach  -->
											<%-- <td><a data-toggle="modal" data-target="#myModal"
												class="btn btn-info" role="button">Delete</a> <!-- <button type="button" class="btn btn-info btn-lg"
										data-toggle="modal" data-target="#myModal" style="margin:0px;">Send
										Access ID</button> --> <!-- Modal -->
												<div class="modal fade" id="myModal" role="dialog">
													<div class="modal-dialog">

														<!-- Modal content-->
														<div class="modal-content">
															<div class="modal-header">
																<button type="button" class="close" data-dismiss="modal">&times;</button>
																<h4 class="modal-title">
																	<b>Delete Coach</b>
																</h4>
															</div>
															<div class="modal-body">
																<p>Are you sure you want to delete coach?</p>
															</div>
															<div class="modal-footer">
																<a href="<spring:url value="/employee/delete/${coach.id}" />"
																	class="btn btn-info" role="button">Delete</a>
															</div>
														</div>
													</div>
												</div> --%>
										</tr>
									</c:forEach>
								
								
								<!-- 
								
								
									<tr>
										<td>Tony</td>
										<td>tony@gmail.com</td>
										<td>Tony123</td>
										<td>tony123</td>
										<td><a href= "admin_editadmin.html">Edit</a></td>
										<td>
											<button type="button" id="del1" class="btn del" onclick="delCategory(this)">
												<span class="glyphicon glyphicon-remove"></span>
											</button>
										</td>
									</tr>
									<tr>
										<td>George</td>
										<td>george@gmail.com</td>
										<td>George</td>
										<td>george123</td>
										<td><a href= "admin_editadmin.html">Edit</a></td>
										<td>
											<button type="button" id="del2" class="btn del" onclick="delCategory(this)">
												<span class="glyphicon glyphicon-remove"></span>
											</button>
										</td>
									</tr> -->
									
								</tbody>
							</table>
						</div>
						<div class="col-sm-1"></div>
					</div>
				</div>
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
	<script
		src='<spring:url value="/resources/js/admin.js"></spring:url>'></script>
	<script
		src='<spring:url value="/resources/js/jquery.dataTables.min.js"></spring:url>'></script>
	<script
		src='<spring:url value="/resources/js/dataTables.bootstrap.min.js"></spring:url>'></script>
	<script
		src='<spring:url value="/resources/js/data_table.js"></spring:url>'></script>


</body>
</html>