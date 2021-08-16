
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from envato.megadrupal.com/html/megacourse/account-assignment.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 19 Mar 2017 04:41:35 GMT -->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <title>${companyName} - Available Test</title>
</head>
<body id="page2"
	style="background:url(${pageContext.request.contextPath}/images/bg_top2.jpg) top repeat-x #fff;"
	onkeydown="return (event.keyCode != 116)">

<!-- PAGE WRAP -->
<div id="page-wrap">

    <!-- HEADER -->
    <header id="header" class="header">
        <%@include file="/lheader.jsp" %>
    </header>
    <!-- END / HEADER -->
   
 </div>
	 <section id="login-content" class="login-content">
        <div class="awe-parallax bg-login-content"></div>
        <div class="awe-overlay"></div>
        <div class="container">
            <div class="row">
                <!-- FORM -->
				  <span id="errorMessage" style="color:black;font-weight: bold;font-size: 20px;">You have already logged into the application , So you cannot create multiple sessions at a time.<br/>
				  
				  <span style="margin-left: 0px;">
				  <a style="color:#01198b;" href="${pageContext.request.contextPath}/action/oauth"><img style="height: 70px;" src="${pageContext.request.contextPath}/images/login-again.png"/>Click here to login now</a>  </span>
				  </span>	
               	  <hr/>
                <div class="col-lg-5 pull-right" style="height: 450px;">
                	
                    <%-- <div class="form-login">
                      <form id="registrationForm" action="${pageContext.request.contextPath}/action/userRegistration" method="post">
                            <h2 class="text-uppercase">sign up</h2>
                              <input type="hidden" name="member" value="yes"/>
                             <div class="form-email">
                                    <span id="errorMessage" style="color:yellow;font-weight: bold;"></span>
                            </div>
                            <div class="form-fullname">
                                <input class ="first-name"type="text" placeholder="First name" name="firstName" style="color:black;">
                                <input class="last-name" type="text" placeholder="Last name" name="lastName" style="color:black;">
                            </div>
                            <div class="form-datebirth">
                                <input type="text" placeholder="Date of Birth" name="dob" style="color:black;">
                            </div>
                            <div class="form-email">
                                <input type="text" placeholder="Email" name="email" style="color:black;">
                            </div>
                            <div class="form-password">
                                <input type="password" placeholder="Password" name="password" style="color:black;">
                            </div>
                            
                            <div class="form-submit-1">
                                <input type="button" id="becomeMemeber" value="Become a member" class="mc-btn btn-style-1">
                            </div>
                            <div class="link">
                                <a href="login.html">
                                    <i class="icon md-arrow-right"></i>Already have account ? Log in
                                </a>
                            </div>
                        </form>
                    </div> --%>
                </div>
                <!-- END / FORM -->
    
                <div class="image">
                    <img src="images/homeslider/logged-in.png" alt="">
                </div>
    
            </div>
        </div>
    </section>
   <!-- FOOTER -->
    <footer id="footer" class="footer">
     <%--   <%@include file="/ffooter.jsp" %> --%>
       <%@include file="/sfooter.jsp" %>
    </footer>
    <!-- END / FOOTER -->



<!-- END / PAGE WRAP -->

  <%@include file="/js.jsp" %>

</body>
</html>