<%@page import="com.synergisitic.it.web.form.UserId"%>
<%@page import="com.synergisitic.it.util.ApplicationContant"%>
<%@page import="com.synergisitic.it.util.ErrorLoggerDBUtils"%>
<%@page import="com.techquiz.codings.web.controller.vo.AppLoggerVO"%>
<%@page import="java.io.PrintStream"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@ page isErrorPage="true" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- Google font -->
    <%@include file="/resources.jsp" %>
    <title>${companyName} - Session Expired</title>
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
                                    ${ApplicationMessage}
                                   </h2>
                               <img src="${pageContext.request.contextPath}/images/icon/success-icon.png" style="height: 48px;">
                                   <p style="font-size: 20px;display: inline;">
                                  Your session has been expired . Please click here to <a href="${pageContext.request.contextPath}/action/oauth">login</a> once again.
                                  </p>
                                  <br/>  <br/>
                                  <p style="font-size: 17px;font-family: rockwell;">
                                  This error has occurred for one of the following reasons:
                                  </p>
                                  <ul style="font-size: 18px;">
                                 			 <li>You have used Back/Forward/Refresh button of your Browser.</li>
											  <li>You have kept the browser window idle for a long time.</li>
											  <li>You have logged in from another browser window</li>
											   <li>You are accessing the application URL from a saved or static page100<%=exception%></li>
											   <%
											      if(exception!=null) {
											    	  UserId userId = (UserId) session.getAttribute(ApplicationContant.USER_SESSION_DATA);
											    	  ByteArrayOutputStream os = new ByteArrayOutputStream();
											    	  exception.printStackTrace(new PrintStream(os));
											    	  AppLoggerVO appLoggerVO=new AppLoggerVO();
											    	  appLoggerVO.setComment(exception.getMessage());
											    	  appLoggerVO.setStacktrace(os.toString());
											    	  appLoggerVO.setLoginDetails(userId!=null?userId.toString():"NA");
											    	  ErrorLoggerDBUtils.logErrorInDb(appLoggerVO);
											    	  %>
											       <li><%=exception.getMessage()%></li>
											     <% } %> 
								</ul>
                               		<a href="${pageContext.request.contextPath}/action/thome">
                               			 	<input type="button"  value="Home Page" class="mc-btn btn-style-1" id="home"/>
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