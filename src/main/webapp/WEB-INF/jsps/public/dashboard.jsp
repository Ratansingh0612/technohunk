<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
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
    <title>${companyName} - User Home</title>
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
   <k:if test="${sessionScope.user_session_data.role=='trainer'}">	
      <%@include file="../trainer/theader.jsp"%>
      </k:if>
        <k:if test="${sessionScope.user_session_data.role=='admin'}">	
       <%@include file="/aheader.jsp"%>
       </k:if>
          <k:if test="${sessionScope.user_session_data.role=='consultant'}">	
      		 <%@include file="guestheader.jsp"%>
       </k:if>
         <k:if test="${sessionScope.user_session_data.role=='user'}">	
       <%@include file="guestheader.jsp"%>
       </k:if>
         <k:if test="${sessionScope.user_session_data.role=='career'}">	
       <%@include file="guestheader.jsp"%>
       </k:if>
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
                    <h2 class="big">${sessionScope.user_session_data.name}</h2>
                </div>     
                <div class="address-author">
                    <i class="fa fa-map-marker"></i>
                        <h3>${sessionScope.user_session_data.address}&nbsp;&nbsp;(${sessionScope.user_session_data.batch})</h3>
                </div>
            </div>
           <%@include file="tech-profile.jsp"%>
        </div>
    </section>
    <!-- END / PROFILE FEATURE -->


    <!-- CONTEN BAR -->
   <%@include file="content-bar.jsp" %>
   <!-- END / CONTENT BAR -->




   

     <!-- COURSE CONCERN -->
    <section id="course-concern" class="course-concern" style="padding-bottom:20px;padding-top: 20px;">
        <div class="container">

            <div class="message-body">
                <div class="row">
                   <div class="col-md-4">
                        <div class="message-sb">
                            <div class="message-sb-title">
                                <h4 style="font-size: 18px;color:black;margin-top: 10px;"> 
                                <img  src="${pageContext.request.contextPath}/images/icon/new-icon.gif" style="height:48px;"/>
                           		Coming New Test(s)</h4>
                              
                            </div>
                            <ul class="list-message">
                                <!-- LIST ITEM -->
                                <k:forEach items="${assignedTestUserList}" var="aOnlineTest">
                                <li class="ac-new">
                                    <a href="${pageContext.request.contextPath}/action/load-tech-test?testName=${aOnlineTest.testName}&techName=${aOnlineTest.techName}">
                                        <div class="image">
                                            <img src="${pageContext.request.contextPath}/images/icon/test-icon.png" alt="">
                                        </div>
                                        <div class="list-body">
                                            <div class="author">
                                                <span>
                                                Start Test
                                                </span>
                                                <div class="div-x"></div>
                                            </div>
                                            <p style="height: 15px;">
                                             Test Name : <span style="color:#f58a00;font-weight: bold;">${aOnlineTest.testName}</span>
                                            </p>
                                        </div>
                                    </a>
                                </li>
                                </k:forEach>
                                <!-- END / LIST ITEM -->

								
                               

								<marquee direction="up" scrolldelay="200">
								
								 <!-- LIST ITEM -->
                                <li class="ac-new">
                                    <a href="#">
                                        <div class="image">
                                             <img src="${pageContext.request.contextPath}/images/icon/tech-icon.png" alt="">
                                        </div>
                                        <div class="list-body">
                                            <div class="author">
                                                <span>ReactJS</span>
                                                <div class="div-x"></div>
                                            </div>
                                               <p>Coming Soon</p>
                                            <div class="time">
                                                <span>After few days</span>
                                            </div>
                                            <div class="indicator">
                                                <i class="icon md-paperclip"></i>
                                            </div>
                                        </div>
                                    </a>
                                </li>
								
								 <!-- LIST ITEM -->
                                <li class="ac-new">
                                    <a href="#">
                                        <div class="image">
                                             <img src="${pageContext.request.contextPath}/images/icon/tech-icon.png" alt="">
                                        </div>
                                        <div class="list-body">
                                            <div class="author">
                                                <span>Angular5</span>
                                                <div class="div-x"></div>
                                            </div>
                                               <p>Coming Soon</p>
                                            <div class="time">
                                                <span>After few days</span>
                                            </div>
                                            <div class="indicator">
                                                <i class="icon md-paperclip"></i>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <!-- LIST ITEM -->
                                <li class="ac-new">
                                    <a href="#">
                                        <div class="image">
                                             <img src="${pageContext.request.contextPath}/images/icon/tech-icon.png" alt="">
                                        </div>
                                        <div class="list-body">
                                            <div class="author">
                                                <span>Python</span>
                                                <div class="div-x"></div>
                                            </div>
                                               <p>Coming Soon</p>
                                            <div class="time">
                                                <span>After few days</span>
                                            </div>
                                            <div class="indicator">
                                                <i class="icon md-paperclip"></i>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <!-- END / LIST ITEM -->

                                <!-- LIST ITEM -->
                                <li>
                                    <a href="#">
                                        <div class="image">
                                         <img src="${pageContext.request.contextPath}/images/icon/tech-icon.png" alt="">
                                        </div>
                                        <div class="list-body">
                                            <div class="author">
                                                <span>Spring</span>
                                                <div class="div-x"></div>
                                            </div>
                                            <p>Coming Soon</p>
                                            <div class="time">
                                                       <span>After few days</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                </marquee>
                                <!-- END / LIST ITEM -->

                            </ul>
                        </div>
                    </div>
                     <div class="col-md-8">
                        <div class="message-ct">
                            <div class="author">
                            				 <a href="${pageContext.request.contextPath}/assessment/career-counseling-report" style="font-size: 16px;color:black;">  
                            				  <img src="${pageContext.request.contextPath}/images/icon/writing-icon.png" style="height: 50px;"/>&nbsp;&nbsp;<b>Career Counseling Test Report</b></a>
                                            <img src="${pageContext.request.contextPath}/images/tech-hunk.png"/>
                                <span class="author-name">
                                  <h4 class="title-box text-uppercase" style="color:black;">
                                  	WELCOME TO ONLINE CAREER COUNSELING TEST!!!!!!!!!
                                  </h4>
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
   <%@include file="/ffooter.jsp" %>

       <%@include file="/sfooter.jsp" %>
    </footer>
    <!-- END / FOOTER -->






</div>
<!-- END / PAGE WRAP -->

<!-- Load jQuery -->
  <%@include file="/js.jsp" %>
</body>
</html>