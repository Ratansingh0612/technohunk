<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from envato.megadrupal.com/html/megacourse/account-learning.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 19 Mar 2017 04:41:35 GMT -->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <!-- Google font -->
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Raleway:300,400,700,900' rel='stylesheet' type='text/css'>
     <%@include file="/resources.jsp" %>
    <title>${companyName} - Admin Home</title>
</head>
<body id="page-top">

<!-- PAGE WRAP -->
<div id="page-wrap">

    <!-- PRELOADER -->
    <div id="preloader">
        <div class="pre-icon">
            <div class="pre-item pre-item-1"></div>
            <div class="pre-item pre-item-2"></div>
            <div class="pre-item pre-item-3"></div>
            <div class="pre-item pre-item-4"></div>
        </div>
    </div>
    <!-- END / PRELOADER -->

    <!-- HEADER -->
     <%@include file="aheader.jsp" %>
    <!-- END / HEADER -->


    <!-- PROFILE FEATURE -->
    <section class="profile-feature">
        <div class="awe-parallax bg-profile-feature"></div>
        <div class="awe-overlay overlay-color-3"></div>
        <div class="container">
            <div class="info-author">
                <div class="image">
                     <img src="${pageContext.request.contextPath}/action/imageByUserId?userid=${sessionScope.user_session_data.loginId}" alt="">
                </div>    
                <div class="name-author">
                    <h2 class="big" style="color:white;;font-size: 24px;">${sessionScope.user_session_data.name}</h2>
                </div>     
                <div class="address-author">
                    <i class="fa fa-map-marker"></i>
             <h3>${sessionScope.user_session_data.address}&nbsp;&nbsp;(${sessionScope.user_session_data.batch})</h3>
                </div>
            </div>
                     <%@include file="/tech-profile.jsp"%>
        </div>
    </section>
    <!-- END / PROFILE FEATURE -->


    <!-- CONTEN BAR -->
   <%@include file="content-bar.jsp" %>
   <!-- END / CONTENT BAR -->




    <!-- COURSE CONCERN -->
       <!-- COURSE CONCERN -->
    <section id="course-concern" class="course-concern" style="padding-bottom:0px;padding-top: 20px;min-height: 620px;">
        <div class="container" style="margin-top: -10px;">
            <div class="message-body">
                <div class="row">
                    <div class="col-md-4">
                        <div class="message-sb">
                           <h2 style="font-size: 16px;font-weight: bold;margin-left: 5px;">Super Admin Panel : -</h2>
                              <img src="${pageContext.request.contextPath}/images/creatividad.jpg" style="width: 200px;"/> 
									
                        </div>
                    </div>

                    <div class="col-md-8">
                        <div class="message-ct">
                      	  <a href="${pageContext.request.contextPath}/action/pending-test-guest-user">	
                          <h3 style="font-size: 16px;display: inline;"><img src="${pageContext.request.contextPath}/images/icon/cheers.png" style="height: 60px;"> - Pending Guest Test</h3>
                          </a>
                          
                          <a href="${pageContext.request.contextPath}/action/codings/java/lists?problemCategory=All" style="margin-left: 100px;">	
                          <h3 style="font-size: 16px;display: inline;"><img src="${pageContext.request.contextPath}/images/codings/coding-icon.png" style="height: 60px;"> - Challenges</h3>
                          </a>
                          	<br/> 	<br/>
                          	<hr/>	
                            <div class="author">
                                       <img src="${pageContext.request.contextPath}/images/admin-home.jpg" style="opacity: .9;"/>
                                <span class="author-name">
                              </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- END / COURSE CONCERN -->

    
    <!-- FOOTER -->
    <footer id="footer" class="footer">
<%--    <%@include file="/ffooter.jsp" %> --%>

       <%@include file="/sfooter.jsp" %>
    </footer>
    <!-- END / FOOTER -->






</div>
<!-- END / PAGE WRAP -->

<!-- Load jQuery -->
  <%@include file="/js.jsp" %>
</body>
</html>