
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

<div class="body121">
  <div class="main">
      <k:if test="${sessionScope.user_session_data.role=='trainer'}">	
      <%@include file="../trainer/theader.jsp"%>
      </k:if>
       <k:if test="${sessionScope.user_session_data.role=='consultant'}">	
      <%@include file="/uheader.jsp"%>
      </k:if>
        <k:if test="${sessionScope.user_session_data.role=='admin'}">	
       <%@include file="/aheader.jsp"%>
       </k:if>
  </div>
</div>
    <!-- PROFILE FEATURE -->
    <%@include file="profile-feature.jsp" %>
    <!-- END / PROFILE FEATURE -->


    <!-- CONTEN BAR -->
     <%@include file="content-bar.jsp" %>
   <!-- END / CONTENT BAR -->
   
   
  
 </div>
	  <!-- AFTER SLIDER -->
    <section id="after-slider" class="after-slider section">
        <div class="awe-color bg-color-1"></div>
        <div class="after-slider-bg-2"></div>
        <div class="container">
    
            <div class="after-slider-content tb">
                <div class="inner tb-cell">
                </div>
                <div class="tb-cell text-right">
                    <div class="form-actions">
                       <a href="${pageContext.request.contextPath}/action/oauth" class="mc-btn btn-style-1">Click here to login!</a>
                    </div>
                </div>
            </div>
    
        </div>
    </section>
    <!-- END / AFTER SLIDER -->
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