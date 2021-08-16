
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
    <title>${companyName} - Confirmation Page</title>
</head>
<body>
<!-- PAGE WRAP -->
<div id="page-wrap">
<div class="body121">
  <div class="main">
    <header id="header" class="header">
        <div class="container">
            <!-- LOGO -->
                <span style="float: right;margin-top: 10px;">
            PHONE  - (510-550-7200)
            </span>
            <div class="logo">
            	<a href="${pageContext.request.contextPath}/${sessionScope.user_session_data.homePage}" style="display: inline;"><img src="${pageContext.request.contextPath}/images/logo.png" alt="" style="margin-top: 0px;"></a>
            </div>
             <br/><br/>       <br/>  
            <!-- END / LOGO -->

            <!-- NAVIGATION -->
            <nav class="navigation">

                <div class="open-menu">
                    <span class="item item-1"></span>
                    <span class="item item-2"></span>
                    <span class="item item-3"></span>
                </div>

                <!-- MENU -->
                <ul class="menu">
                    <li><a href="${pageContext.request.contextPath}/${sessionScope.user_session_data.homePage}">Home</a></li>
                   
                    <li>
                        <a href="#">Study Materials</a>
                    </li>
                    
                    <li>
                        <a href="#">Course</a>
                    </li>
                    <%--  <li><a href="${pageContext.request.contextPath}/action/uchange-password">Change Password</a>
                    </li> --%>
                </ul>
                <!-- END / MENU -->

                <!-- SEARCH BOX -->
                <div class="search-box">
                    <i class="icon md-search"></i>
                    <div class="search-inner">
                        <form>
                            <input type="text" placeholder="key words">
                        </form>
                    </div>
                </div>
                <!-- END / SEARCH BOX -->

                <!-- LIST ACCOUNT INFO -->
                <ul class="list-account-info">
                      <!-- MESSAGE INFO -->
                    <li class="list-item messages">
                        <div class="message-info item-click">
                            <i class="icon md-email"></i>
                            <span class="itemnew"></span>
                        </div>
                        <div class="toggle-message toggle-list">
                            <div class="list-profile-title">
                                <h4>Inbox message</h4>
                                <span class="count-value">3</span>
                                <a href="#" class="new-message"><i class="icon md-pencil"></i></a>
                            </div>
                            <ul class="list-message">

                                <!-- LIST ITEM -->
                                <li class="ac-new">
                                    <a href="#">
                                        <div class="image">
                                            <img src="${pageContext.request.contextPath}/images/team-13.jpg" alt="">
                                        </div>
                                        <div class="list-body">
                                            <div class="author">
                                                <span>Megacourse</span>
                                                <div class="div-x"></div>
                                            </div>
                                            <p>We are waiting for test</p>
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
                                            <img src="${pageContext.request.contextPath}/images/icon/user-icon.png" alt="">
                                        </div>
                                        <div class="list-body">
                                            <div class="author">
                                                <span>Ashutosh Singh</span>
                                                <div class="div-x"></div>
                                            </div>
                                            <p>We are waiting for test</p>
                                            <div class="time">
                                                <span>5 days ago</span>
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
                                                <span>Sasha Grey</span>
                                                <div class="div-x"></div>
                                            </div>
                                            <p>Yeah test was really fantastic...</p>
                                            <div class="time">
                                                <span>5 days ago</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <!-- END / LIST ITEM -->

                                <!-- LIST ITEM -->
                                <li>
                                    <a href="#">
                                        <div class="image">
                                           <img src="${pageContext.request.contextPath}/images/icon/user-icon.png" alt="">
                                        </div>
                                        <div class="list-body">
                                            <div class="author">
                                                <span>Neha Singh</span>
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

                                <!-- LIST ITEM -->
                                <li>
                                    <a href="#">
                                        <div class="image">
                                            <img src="${pageContext.request.contextPath}/images/team-13.jpg" alt="">
                                        </div>
                                        <div class="list-body">
                                            <div class="author">
                                                <span>Pawan Gulati</span>
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

                                <!-- LIST ITEM -->
                                <li>
                                    <a href="#">
                                        <div class="image">
                                             <img src="${pageContext.request.contextPath}/images/icon/user-icon.png" alt="">
                                        </div>
                                        <div class="list-body">
                                            <div class="author">
                                                <span>Amanda Gleam</span>
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
                            <div class="viewall">
                                <a href="#">view all 80 messages</a>
                            </div>
                        </div>
                    </li>
                    <!-- END / MESSAGE INFO -->

                    <!-- NOTIFICATION -->
                    <li class="list-item notification">
                        <div class="notification-info item-click">
                            <i class="icon md-bell"></i>
                            <span class="itemnew"></span>
                        </div>
                        <div class="toggle-notification toggle-list">
                            <div class="list-profile-title">
                                <h4>Notification</h4>
                                <span class="count-value">2</span>
                            </div>

                            <ul class="list-notification">

                                <!-- LIST ITEM -->
                                <li class="ac-new">
                                    <a href="#">
                                        <div class="list-body">
                                            <div class="author">
                                                <span>C++</span>
                                                <div class="div-x"></div>
                                            </div>
                                                <p>online test is starting soon.</p>
                                            <div class="image">
                                                <img src="${pageContext.request.contextPath}/images/feature/img-1.jpg" alt="">
                                            </div>
                                            <div class="time">
                                                <span>5 minutes ago</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <!-- END / LIST ITEM -->

                                <!-- LIST ITEM -->
                                <li class="ac-new">
                                    <a href="#">
                                        <div class="list-body">
                                            <div class="author">
                                                <span>Python</span>
                                                <div class="div-x"></div>
                                            </div>
                                               <p>online test is starting soon.</p>
                                            <div class="image">
                                                  <img src="${pageContext.request.contextPath}/images/icon/user-icon.png" alt="">
                                            </div>
                                            <div class="time">
                                                <span>5 minutes ago</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <!-- END / LIST ITEM -->

                                <!-- LIST ITEM -->
                                <li>
                                    <a href="#">
                                        <div class="list-body">
                                            <div class="author">
                                                <span>PHP</span>
                                                <div class="div-x"></div>
                                            </div>
                                            <p>online test is starting soon.</p>
                                            <div class="image">
                                                <img src="${pageContext.request.contextPath}/images/feature/img-1.jpg" alt="">
                                            </div>
                                            <div class="time">
                                                <span>5 minutes ago</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <!-- END / LIST ITEM -->

                                <!-- LIST ITEM -->
                                <li>
                                    <a href="#">
                                        <div class="list-body">
                                            <div class="author">
                                                <span>Java</span>
                                                <div class="div-x"></div>
                                            </div>
                                              <p>online test is starting soon.</p>
                                            <div class="image">
                                                        <img src="${pageContext.request.contextPath}/images/icon/user-icon.png" alt="">
                                            </div>
                                            <div class="time">
                                                <span>5 minutes ago</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <!-- END / LIST ITEM -->

                                <!-- LIST ITEM -->
                                <li>
                                    <a href="#">
                                        <div class="list-body">
                                            <div class="author">
                                                <span>.NET</span>
                                                <div class="div-x"></div>
                                            </div>
                                            <p>online test is starting soon.</p>
                                            <div class="image">
                                                <img src="${pageContext.request.contextPath}/images/feature/img-1.jpg" alt="">
                                            </div>
                                            <div class="time">
                                                <span>5 minutes ago</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <!-- END / LIST ITEM -->

                                <!-- LIST ITEM -->
                                <li>
                                    <a href="#">
                                        <div class="list-body">
                                            <div class="author">
                                                <span>Data Structure</span>
                                                <div class="div-x"></div>
                                            </div>
                                             <p>online test is starting soon.</p>
                                            <div class="image">
                                                <img src="${pageContext.request.contextPath}/images/icon/user-icon.png" alt="">
                                            </div>
                                            <div class="time">
                                                <span>5 minutes ago</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <!-- END / LIST ITEM -->

                                

                            </ul>
                        </div>
                    </li>
                    <!-- END / NOTIFICATION -->

                    <li class="list-item account">
                        <div class="account-info item-click">
                            		<img src="${pageContext.request.contextPath}/action/imageByUserId?userid=${sessionScope.user_session_data.loginId}" alt="">
                        	</div>
                        <div class="toggle-account toggle-list">
                            <ul class="list-account">
                                <li><a href="#"><i class="icon md-config"></i>Setting</a></li>
                                <li><a href="${pageContext.request.contextPath}/action/leaveTest?testName=${utestName}&techName=${utechName}"><i class="icon md-arrow-right"></i>Leave Test</a></li>
                            </ul>
                        </div>
                    </li>


                </ul>
                <!-- END / LIST ACCOUNT INFO -->

            </nav>
            <!-- END / NAVIGATION -->

        </div>
    </header>
  </div>
</div>
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
                    <h2 class="big">${guestUserForm.name}</h2>
                </div>     
                <div class="address-author">
                    <i class="fa fa-map-marker"></i>
                    <h3>${guestUserForm.occupation} (${guestUserForm.mobile})</h3>
                </div>
            </div>
     <%@include file="/tech-profile.jsp"%>
        </div>
    </section>
    <!-- END / PROFILE FEATURE -->


    <!-- CONTEN BAR -->
   <!-- END / CONTENT BAR -->
  
 </div>
  <!-- SECTION 1 -->
    <section id="mc-section-1" class="mc-section-1 section">
        <div class="container">
            <div class="row">
                        <div class="col-sm-12">
                            <div class="featured-item">
                               <h2 style="font-size: 20px;">
                               <img src="${pageContext.request.contextPath}/images/icon/success-icon.png" style="height: 48px;">
                               ${ApplicationMessage}!!!</h2>
                            </div>
                        </div>
    
                </div>
    </div>
    </section>
    <!-- END / SECTION 1 -->
    
      <!-- BEFORE FOOTER -->
    <section id="before-footer" class="before-footer" style="background-color: #fff8f8;height: 80px;margin-top: 100px;">
        <div class="container">
            <div class="row">
                
                <div class="col-lg-8">
                    <img src="${pageContext.request.contextPath}/images/icon/status.png" style="height:96px;"/> 
                </div>
    
                <div class="col-lg-4">
                    <div class="before-footer-link">
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- END / BEFORE FOOTER -->
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