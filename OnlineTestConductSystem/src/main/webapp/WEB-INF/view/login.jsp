

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MUM Online Test System</title>

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

<link href="<c:url value = '/resources/js/nprogress/nprogress.css'></c:url>" rel="stylesheet" type="text/css">
<!-- Animate.css -->
<link href="<c:url value = '/resources/css/animate.css/animate.min.css'></c:url>" rel="stylesheet" type="text/css">

<!-- Custom Theme Style -->
<link href="<c:url value = '/resources/css/custom.min.css'></c:url>" rel="stylesheet" type="text/css">
<link href="<c:url value = '/resources/css/login.css'></c:url>" rel="stylesheet" type="text/css">
</head>
<body class="login">
    <div>
      <a class="hiddenanchor" id="signup"></a>
      <a class="hiddenanchor" id="signin"></a>
      <div align="center" id="imgDiv">
        <img src="/OnlineTestConductSystem/resources/images/Maharishi.png" alt="..." style="height:100px;width:100px;line-height: 100px;">
      </div>
      <div class="login_wrapper">
        <div class="animate form login_form">
          <section class="login_content">
            <form action="<spring:url value="/postLogin"></spring:url>" method="post">
              <h1>Login Form</h1>
              <div>
                <input type="text" id="username" name="username" class="form-control" placeholder="Username" required="" />
              </div>
              <div>
                <input type="password"  name='password' class="form-control" placeholder="Password" required="" />
              </div>
              <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
	 		  <input type="checkbox" name="keepMe">Remember Me?
              <div>
                <input type="submit" class="btn btn-default submit" value="Log in">
                <a class="reset_pass" href="#">Lost your password?</a>
              </div>

              <div class="clearfix"></div>

              <div class="separator">
                <p class="change_link">New to site?
                  <a href="#signup" class="to_register"> Create Account </a>
                </p>

                <div class="clearfix"></div>
                <br />

                <div>
                  <h1><i class="fa fa-user"></i> MUM Online Test System</h1>
                  <p>&copy; 2017 Maharishi University of Management. All rights reserved.</p>
                </div>
              </div>
            </form>
          </section>
        </div>

        <div id="register" class="animate form registration_form">
          <section class="login_content">
            <form>
              <h1>Create Account</h1>
              <div>
                <input type="text" class="form-control" placeholder="Username" required="" />
              </div>
              <div>
                <input type="email" class="form-control" placeholder="Email" required="" />
              </div>
              <div>
                <input type="password" class="form-control" placeholder="Password" required="" />
              </div>
              <div>
                <a class="btn btn-default submit" href="da_add_question.html">Submit</a>
              </div>

              <div class="clearfix"></div>

              <div class="separator">
                <p class="change_link">Already a member ?
                  <a href="#signin" class="to_register"> Log in </a>
                </p>

                <div class="clearfix"></div>
                <br />

                <div>
                  <h1><i class="fa fa-user"></i> MUM Online Test System</h1>
                  <p>&copy; 2017 Maharishi University of Management. All rights reserved.</p>
                </div>
              </div>
            </form>
          </section>
        </div>
      </div>
    </div>
  </body>
</html>