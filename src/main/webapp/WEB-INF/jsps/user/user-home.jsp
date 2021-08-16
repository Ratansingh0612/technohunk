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
       <%@include file="uheader.jsp"%>
       </k:if>
         <k:if test="${sessionScope.user_session_data.role=='user'}">	
       <%@include file="uheader.jsp"%>
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
           <%@include file="/tech-profile.jsp"%>
        </div>
    </section>
    <!-- END / PROFILE FEATURE -->


    <!-- CONTEN BAR -->
   <%@include file="content-bar.jsp" %>
   <!-- END / CONTENT BAR -->




    <!-- COURSE CONCERN -->
    <section id="course-concern" class="course-concern">
        <div class="container">
            <div class="row">
                <div class="col-xs-6 col-sm-4 col-md-3">
                    <!-- MC ITEM -->
                    <div class="mc-learning-item mc-item mc-item-2">
                        <div class="image-heading">
                            <img src="${pageContext.request.contextPath}/images/feature/img-1.jpg" alt="">
                        </div>
                        <div class="meta-categories"><a href="#">Web design</a></div>
                        <div class="content-item">
                            <div class="image-author">
                                <img src="${pageContext.request.contextPath}/images/avatar-1.jpg" alt="">
                            </div>
                            <h4><a href="course-intro.html">Advanced Tactics with Hoot Suite Pro</a></h4>
                            <div class="name-author">
                                By <a href="#">Name of Mr or Mrs</a>
                            </div>
                        </div>
                        <div class="ft-item">
                            <div class="percent-learn-bar">
                                <div class="percent-learn-run"></div>
                            </div>
                            <div class="percent-learn">100%<i class="fa fa-trophy"></i></div>
                            <a href="#" class="learnnow">Learn now<i class="fa fa-play-circle-o"></i></a>
                        </div>
                    </div>
                    <!-- END / MC ITEM -->
                </div>

                <div class="col-xs-6 col-sm-4 col-md-3">
                    <!-- MC ITEM -->
                    <div class="mc-learning-item mc-item mc-item-2">
                        <div class="image-heading">
                            <img src="${pageContext.request.contextPath}/images/feature/img-1.jpg" alt="">
                        </div>
                        <div class="meta-categories"><a href="#">Web design</a></div>
                        <div class="content-item">
                            <div class="image-author">
                                <img src="${pageContext.request.contextPath}/images/avatar-1.jpg" alt="">
                            </div>
                            <h4><a href="course-intro.html">Advanced Tactics with Hoot Suite Pro</a></h4>
                            <div class="name-author">
                                By <a href="#">Name of Mr or Mrs</a>
                            </div>
                        </div>
                        <div class="ft-item">
                            <div class="percent-learn-bar">
                                <div class="percent-learn-run"></div>
                            </div>
                            <div class="percent-learn">75%</div>
                            <a href="#" class="learnnow">Learn now<i class="fa fa-play-circle-o"></i></a>
                        </div>
                    </div>
                    <!-- END / MC ITEM -->
                </div>

                <div class="col-xs-6 col-sm-4 col-md-3">
                    <!-- MC ITEM -->
                    <div class="mc-learning-item mc-item mc-item-2">
                        <div class="image-heading">
                            <img src="${pageContext.request.contextPath}/images/feature/img-1.jpg" alt="">
                        </div>
                        <div class="meta-categories"><a href="#">Web design</a></div>
                        <div class="content-item">
                            <div class="image-author">
                                <img src="${pageContext.request.contextPath}/images/avatar-1.jpg" alt="">
                            </div>
                            <h4><a href="course-intro.html">Advanced Tactics with Hoot Suite Pro</a></h4>
                            <div class="name-author">
                                By <a href="#">Name of Mr or Mrs</a>
                            </div>
                        </div>
                        <div class="ft-item">
                            <div class="percent-learn-bar">
                                <div class="percent-learn-run"></div>
                            </div>
                            <div class="percent-learn">100%<i class="fa fa-trophy"></i></div>
                            <a href="#" class="learnnow">Learn now<i class="fa fa-play-circle-o"></i></a>
                        </div>
                    </div>
                    <!-- END / MC ITEM -->
                </div>

                <div class="col-xs-6 col-sm-4 col-md-3">
                    <!-- MC ITEM -->
                    <div class="mc-learning-item mc-item mc-item-2">
                        <div class="image-heading">
                            <img src="${pageContext.request.contextPath}/images/feature/img-1.jpg" alt="">
                        </div>
                        <div class="meta-categories"><a href="#">Web design</a></div>
                        <div class="content-item">
                            <div class="image-author">
                                <img src="${pageContext.request.contextPath}/images/avatar-1.jpg" alt="">
                            </div>
                            <h4><a href="course-intro.html">Advanced Tactics with Hoot Suite Pro</a></h4>
                            <div class="name-author">
                                By <a href="#">Name of Mr or Mrs</a>
                            </div>
                        </div>
                        <div class="ft-item">
                            <div class="percent-learn-bar">
                                <div class="percent-learn-run"></div>
                            </div>
                            <div class="percent-learn">0%</div>
                            <a href="#" class="learnnow">Learn now<i class="fa fa-play-circle-o"></i></a>
                        </div>
                    </div>
                    <!-- END / MC ITEM -->
                </div>

                <div class="col-xs-6 col-sm-4 col-md-3">
                    <!-- MC ITEM -->
                    <div class="mc-learning-item mc-item mc-item-2">
                        <div class="image-heading">
                            <img src="${pageContext.request.contextPath}/images/feature/img-1.jpg" alt="">
                        </div>
                        <div class="meta-categories"><a href="#">Web design</a></div>
                        <div class="content-item">
                            <div class="image-author">
                                <img src="${pageContext.request.contextPath}/images/avatar-1.jpg" alt="">
                            </div>
                            <h4><a href="course-intro.html">Advanced Tactics with Hoot Suite Pro</a></h4>
                            <div class="name-author">
                                By <a href="#">Name of Mr or Mrs</a>
                            </div>
                        </div>
                        <div class="ft-item">
                            <div class="percent-learn-bar">
                                <div class="percent-learn-run"></div>
                            </div>
                            <div class="percent-learn">90%</div>
                            <a href="#" class="learnnow">Learn now<i class="fa fa-play-circle-o"></i></a>
                        </div>
                    </div>
                    <!-- END / MC ITEM -->
                </div>

                <div class="col-xs-6 col-sm-4 col-md-3">
                    <!-- MC ITEM -->
                    <div class="mc-learning-item mc-item mc-item-2">
                        <div class="image-heading">
                            <img src="${pageContext.request.contextPath}/images/feature/img-1.jpg" alt="">
                        </div>
                        <div class="meta-categories"><a href="#">Web design</a></div>
                        <div class="content-item">
                            <div class="image-author">
                                <img src="${pageContext.request.contextPath}/images/avatar-1.jpg" alt="">
                            </div>
                            <h4><a href="course-intro.html">Advanced Tactics with Hoot Suite Pro</a></h4>
                            <div class="name-author">
                                By <a href="#">Name of Mr or Mrs</a>
                            </div>
                        </div>
                        <div class="ft-item">
                            <div class="percent-learn-bar">
                                <div class="percent-learn-run"></div>
                            </div>
                            <div class="percent-learn">45%</div>
                            <a href="#" class="learnnow">Learn now<i class="fa fa-play-circle-o"></i></a>
                        </div>
                    </div>
                    <!-- END / MC ITEM -->
                </div>

                <div class="col-xs-6 col-sm-4 col-md-3">
                    <!-- MC ITEM -->
                    <div class="mc-learning-item mc-item mc-item-2">
                        <div class="image-heading">
                            <img src="${pageContext.request.contextPath}/images/feature/img-1.jpg" alt="">
                        </div>
                        <div class="meta-categories"><a href="#">Web design</a></div>
                        <div class="content-item">
                            <div class="image-author">
                                <img src="${pageContext.request.contextPath}/images/avatar-1.jpg" alt="">
                            </div>
                            <h4><a href="course-intro.html">Advanced Tactics with Hoot Suite Pro</a></h4>
                            <div class="name-author">
                                By <a href="#">Name of Mr or Mrs</a>
                            </div>
                        </div>
                        <div class="ft-item">
                            <div class="percent-learn-bar">
                                <div class="percent-learn-run"></div>
                            </div>
                            <div class="percent-learn">30%</div>
                            <a href="#" class="learnnow">Learn now<i class="fa fa-play-circle-o"></i></a>
                        </div>
                    </div>
                    <!-- END / MC ITEM -->
                </div>

                <div class="col-xs-6 col-sm-4 col-md-3">
                    <!-- MC ITEM -->
                    <div class="mc-learning-item mc-item mc-item-2">
                        <div class="image-heading">
                            <img src="${pageContext.request.contextPath}/images/feature/img-1.jpg" alt="">
                        </div>
                        <div class="meta-categories"><a href="#">Web design</a></div>
                        <div class="content-item">
                            <div class="image-author">
                                <img src="${pageContext.request.contextPath}/images/avatar-1.jpg" alt="">
                            </div>
                            <h4><a href="course-intro.html">Advanced Tactics with Hoot Suite Pro</a></h4>
                            <div class="name-author">
                                By <a href="#">Name of Mr or Mrs</a>
                            </div>
                        </div>
                        <div class="ft-item">
                            <div class="percent-learn-bar">
                                <div class="percent-learn-run"></div>
                            </div>
                            <div class="percent-learn">10%</div>
                            <a href="#" class="learnnow">Learn now<i class="fa fa-play-circle-o"></i></a>
                        </div>
                    </div>
                    <!-- END / MC ITEM -->
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