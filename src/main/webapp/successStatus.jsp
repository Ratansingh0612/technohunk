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
<body id="page2"
	style="background:url(${pageContext.request.contextPath}/images/bg_top2.jpg) top repeat-x #fff;"
	onkeydown="return (event.keyCode != 116)">

<!-- PAGE WRAP -->
<div id="page-wrap">

<div class="body121">
  <div class="main">
      <%@include file="/guestheader.jsp"%>
  </div>
</div>

   
   
  
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
                               ${ApplicationMessage}!!!
                                  Congratulations <font style="color: #fb7e25;">"${param.name}</font> !, your test has been configured successfully and link has been sent to your registered email id 
                                  <font style="color: #fb7e25;">"${param.email}"</font> , please open your email and  click on the link to
                                  start the test. <br/><br/>Note : This test link is valid for only <font style="font-weight: bold;">48</font> hrs.
                               </h2>
                               		<a href="${pageContext.request.contextPath}/action/thome">
                               			 	<input type="button"  value="Home" class="mc-btn btn-style-1" id="home"/>
                                	</a>
                            </div>
                        </div>
    
                </div>
    </div>
    </section>
    <!-- END / SECTION 1 -->
        <br/><br/><br/><br/><br/>
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