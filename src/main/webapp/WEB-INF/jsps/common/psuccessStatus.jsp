
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
    <title>${companyName} - Confirmation Page</title>
</head>
<body id="page2"
	style="background:url(${pageContext.request.contextPath}/images/bg_top2.jpg) top repeat-x #fff;"
	onkeydown="return (event.keyCode != 116)">

<div>
  <div class="main">
      <header id="header" class="header">
        <%@include file="/lheader.jsp" %>
    </header>
  </div>
</div>


    <!-- CONTEN BAR -->
   <%--   <%@include file="content-bar.jsp" %> --%>
   <!-- END / CONTENT BAR -->
   
   
  
	  <!-- AFTER SLIDER -->
    <section id="after-slider" class="after-slider section">
       
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
                               
                                 <img src="${pageContext.request.contextPath}/images/students-celebrating-600x534.png" style="height: auto;">
                            </div>
                        </div>
    
                </div>
    </div>
    </section>
    <!-- END / SECTION 1 -->
    
      <!-- BEFORE FOOTER -->
    <section id="before-footer" class="before-footer" style="background-color: #fff8f8;height: 80px;margin-top: 0px;">
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
  <%@include file="/js.jsp" %>
</body>
</html>