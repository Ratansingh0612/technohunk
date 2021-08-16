<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <!-- Google font -->
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Raleway:300,400,700,900' rel='stylesheet' type='text/css'>
     <%@include file="/resources.jsp" %>
    <title>${companyName} - Trainer Home</title>
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
     <%@include file="theader.jsp" %>
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
                 <%@include file="/tech-profile.jsp" %>
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
                                <h4> 
                                <img  src="${pageContext.request.contextPath}/images/icon/writing-icon.png" style="height:48px;"/>
                                 <a style="font-size: 14px;font-weight: bold;" href="${pageContext.request.contextPath}/action/configure-test" class="new-message"><i class="icon md-plus"></i>New Created Test</a></h4>
                              
                            </div>
                            <ul class="list-message">
                                <!-- LIST ITEM -->
                                <li class="ac-new">
                                    <a href="#">
                                        <div class="image">
                                            <img src="${pageContext.request.contextPath}/images/icon/nodejs.png" alt="">
                                        </div>
                                        <div class="list-body">
                                            <div class="author">
                                                <span>Node.js</span>
                                                <div class="div-x"></div>
                                            </div>
                                            <p style="height: 15px;">In an event-driven application, there is a main loop that listens for events..</p>
                                        </div>
                                    </a>
                                </li>
                                <!-- END / LIST ITEM -->

                                <!-- LIST ITEM -->
                                <li class="ac-new">
                                    <a href="#">
                                        <div class="image">
                                            <img src="${pageContext.request.contextPath}/images/team-13.jpg" alt="">
                                        </div>
                                        <div class="list-body">
                                            <div class="author">
                                                <span>.NET</span>
                                                <div class="div-x"></div>
                                            </div>
                                            <p>Welcome message</p>
                                            <div class="time">
                                                <span>12:53</span>
                                            </div>
                                            <div class="indicator">
                                                <i class="icon md-paperclip"></i>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <!-- END / LIST ITEM -->

                                <!-- LIST ITEM -->
                                <li class="ac-new">
                                    <a href="#">
                                        <div class="image">
                                            <img src="${pageContext.request.contextPath}/images/team-13.jpg" alt="">
                                        </div>
                                        <div class="list-body">
                                            <div class="author">
                                                <span>Java</span>
                                                <div class="div-x"></div>
                                            </div>
                                            <p>Welcome message</p>
                                            <div class="time">
                                                <span>12:53</span>
                                            </div>
                                            <div class="indicator">
                                                <i class="icon md-paperclip"></i>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <!-- END / LIST ITEM -->


                                <!-- LIST ITEM -->
                                <li class="ac-new">
                                    <a href="#">
                                        <div class="image">
                                            <img src="${pageContext.request.contextPath}/images/team-13.jpg" alt="">
                                        </div>
                                        <div class="list-body">
                                            <div class="author">
                                                <span>Python</span>
                                                <div class="div-x"></div>
                                            </div>
                                            <p>Maecenas sodales, nisl eget dign...</p>
                                            <div class="time">
                                                <span>5 days ago</span>
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
                                            <img src="${pageContext.request.contextPath}/images/team-13.jpg" alt="">
                                        </div>
                                        <div class="list-body">
                                            <div class="author">
                                                <span>Spring</span>
                                                <div class="div-x"></div>
                                            </div>
                                            <p>Message title</p>
                                            <div class="time">
                                                <span>5 days ago</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <!-- END / LIST ITEM -->

                            </ul>
                        </div>
                    </div>

                    <div class="col-md-8">
                        <h2 style="font-size: 18px;font-weight: bold;">Trainer Home Page : -</h2>
                        <div class="message-ct">
                            <div class="author">
                                         <img src="${pageContext.request.contextPath}/images/tech-hunk.png"/>
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