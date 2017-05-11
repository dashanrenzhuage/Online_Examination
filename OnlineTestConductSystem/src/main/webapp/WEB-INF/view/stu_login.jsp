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
<link href="<c:url value = '/resources/css/login.css'></c:url>" rel="stylesheet" type="text/css">



<title>MUM Online Test Conduct System</title>
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
            
           <h1>Student Login</h1>
           
            <form action = "studentExamSelection" method = "post">
              	<div>
              	 	 <input type="text" name= "accessCode" class="form-control" placeholder="Please Enter Access ID" required=""  />
              	</div>
             	 <div>
               	 <%-- <a class="btn btn-default submit" href="<spring:url value="/students/studentExamSelection" />">Log in</a> --%>
					<input style="margin-left:0px;text-align:center;" class="btn btn-default submit" type="submit" value="Log in">	              	
              	</div>
			</form>
              <div class="clearfix"></div>

              <div class="separator">
                <div class="clearfix"></div>
                <br />

                <div>
                  <h1><i class="fa fa-user"></i> MUM Online Test System</h1>
                  <p>&copy; 2017 Maharishi University of Management. All rights reserved.</p>
                </div>
              </div>
            
          </section>
        </div>
      </div>
    </div>
  </body>
  
  </html>
