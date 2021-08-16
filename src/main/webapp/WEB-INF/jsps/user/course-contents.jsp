<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from envato.megadrupal.com/html/megacourse/account-teaching.html by HTTrack Website Copier/3.x [XR&CO'2014], Sun, 19 Mar 2017 04:41:35 GMT -->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <!-- Google font -->
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Raleway:300,400,700,900' rel='stylesheet' type='text/css'>
     <%@include file="/resources.jsp" %>
    <title>${companyName} - Course Contents</title>

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
     <%@include file="uheader.jsp" %>
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
                    <h3>${sessionScope.user_session_data.address}</h3>
                </div>
            </div>
              <%@include file="/tech-profile.jsp"%>
        </div>
    </section>
    <!-- END / PROFILE FEATURE -->


    <!-- CONTEN BAR -->
   <%@include file="content-bar.jsp" %>
   <!-- END / CONTENT BAR -->

   <!-- END / CONTENT BAR -->
 
    
    <!-- COURSE CONCERN -->
    <section id="course-concern" class="course-concern">
        <div class="container">
            
<!--             <div class="price-course"> -->
<!--                 <i class="icon md-database"></i> -->
<!--                 <h3>Available Balance </h3> -->
<!--                 <span>$ 29,278</span> -->
<!--                 <div class="create-coures"> -->
<!--                     <a href="#" class="mc-btn btn-style-1">Create new course</a> -->
<!--                     <a href="#" class="mc-btn btn-style-5">Request Payment</a> -->
<!--                 </div> -->

<!--             </div> -->
            <div class="row">
            	<k:forEach items="${technologies}" var="item">
                <div class="col-xs-6 col-sm-4 col-md-3">
                    <!-- MC ITEM -->
                    <div class="mc-teaching-item mc-item mc-item-2">
                        <div class="image-heading">
                            <img src="${pageContext.request.contextPath}/images/feature/${item.image}" alt="">
                        </div>
                        <div class="meta-categories"><a href="#">${item.tname}</a></div>
                        <div class="content-item">
                            <div class="image-author">
                                <img src="${pageContext.request.contextPath}/images/avatar-1.jpg" alt="">
                            </div>
                            <h4>${item.description}</h4>
                        </div>
                        <!-- <div class="ft-item">
                            <div class="rating">
                                <a href="#" class="active"></a>
                                <a href="#" class="active"></a>
                                <a href="#" class="active"></a>
                                <a href="#"></a>
                                <a href="#"></a>
                            </div>
                            <div class="view-info">
                                <i class="icon md-users"></i>
                                2568
                            </div>
                            <div class="comment-info">
                                <i class="icon md-comment"></i>
                                25
                            </div>
                            <div class="price">
                                $190
                            </div>
                        </div> -->

                        <div class="edit-view" style="text-align:center;">
                            <a href="${pageContext.request.contextPath}/action/course-details?tid=${item.id}" class="view">View</a>
                        </div>
                    </div>
                    <!-- END / MC ITEM -->
                </div>

       </k:forEach>
                
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