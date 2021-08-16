<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="k" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
    <title>${companyName} -Find Longest Pattern</title>
    <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
    <![endif]-->
    <style type="text/css">
   
    .scrollcoll {
    padding: 2%;
    width: 100%;
    background-color: #e7eeef2b;
    color: #454C5F;
    font-size: 16px;
    line-height: 20px;
    border-left: 5px solid #1b7175;
    margin: 2%;
    box-shadow: 0 0.125rem 0.625rem 0 rgba(0,0,0,0.2);
    float: left;
}

.ptextarea {
    padding: .5%;
    width: 100%;
    background-color: #e7eeef2b;
    color: #454C5F;
    font-weight: 400;
    font-size: 16px;
    line-height: 20px;
    border-left: 5px solid #48e244;
    border-right: 5px solid #f44336;
    box-shadow: 0 0.125rem 0.625rem 0 rgba(0,0,0,0.2);
    float: left;
}

.ptestsummary {
    padding: 1%;
    width: 90%;
    background-color: #e7eeef2b;
    color: #454C5F;
    font-weight: 400;
    font-size: 16px;
    line-height: 20px;
    border-left: 5px solid #c2bcf9;
    border-right: 5px solid red;
    box-shadow: 0 0.125rem 0.625rem 0 rgba(0,0,0,0.2);
    float: left;
}

.probscrollcoll {
    padding: 2%;
    width: 100%;
    background-color: #e7eeef2b;
    color: #454C5F;
    font-weight: 400;
    font-size: 16px;
    line-height: 20px;
    border-left: 5px solid #c2bcf9;
    margin: 2%;
    box-shadow: 0 0.125rem 0.625rem 0 rgba(0,0,0,0.2);
    float: left;
}
 .subscrollcoll {
    padding: 2%;
    width: 100%;
    background-color: #e7eeef2b;
    color: #454C5F;
    font-weight: 400;
    font-size: 16px;
    line-height: 20px;
    border-left: 5px solid #8bc34a;
    margin: 2%;
    box-shadow: 0 0.125rem 0.625rem 0 rgba(0,0,0,0.2);
    float: left;
}

 .breadscrumscrollcoll {
    padding: 1%;
    width: 100%;
    background-color: #e7eeef2b;
    color: #454C5F;
    font-size: 16px;
    line-height: 20px;
    font-weight:bold;
    border-left: 5px solid #c2bcf9;
    margin: 1%;
    box-shadow: 0 0.125rem 0.625rem 0 rgba(0,0,0,0.2);
    float: left;
}

input[type=radio]{
  display:none;
}

input[type=radio] + label:after{
  content: '';
  display:inline-block;
  border-radius: 8px;
  width: 12px;
  height:12px;
  background:white;
  color:blue;
  border: 1px solid black;
  line-height: 11px;
  text-align: center;
  margin-right: 5px;
}

input[type=radio]:checked + label:after{
  color: red;
   background:#b65efe;
}
    </style>
   
  <style type="text/css" media="screen">
    #javacode {
    border-style: solid;
    border-width: 1px;
    border-color:#009688;
    height: 500px;
    }
    
    
    
  </style>
    
</head>
<body id="page-top">

<!-- PAGE WRAP -->
<div id="page-wrap">

    <!-- PRELOADER -->
    <div id="preloader">

    </div>
    <!-- END / PRELOADER -->

    <!-- HEADER -->
       <!-- HEADER -->
         <!-- header -->
   <k:if test="${sessionScope.user_session_data.role=='user'}">	
      <%@include file="/uheader.jsp" %>
      </k:if>
      <k:if test="${sessionScope.user_session_data.role=='consultant'}">	
      <%@include file="/uheader.jsp" %>
      </k:if>
        <k:if test="${sessionScope.user_session_data.role=='trainer'}">	
       <%@include file="/theader.jsp" %>
       </k:if>
             <k:if test="${sessionScope.user_session_data.role=='admin'}">	
       <%@include file="/aheader.jsp" %>
           </k:if>
                <k:if test="${sessionScope.user_session_data.role=='guest'}">	
       <%@include file="/guestheader.jsp" %>
           </k:if>
           
    <!-- / header -->
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
   <%@include file="../../admin/content-bar.jsp" %>
   <!-- END / CONTENT BAR -->
    <!-- BLOG -->
    <section class="blog">
        <div class="container" style="background-color: white;">
        	 <%@ include file="pheader.jsp"%>
            <div class="row">
                <!-- BLOG LIST -->
                <div class="col-md-8">
                    <div class="blog-list-content">
                   	  <!-- POST -->
                   	   <%@ include file="ppost.jsp"%>
                          <span style="margin-left: 20px;font-size: 18px;color:#61b91a;width:400px;font-weight: bold;">	
                         		 Problem Statement : -
                          </span> 	
                         <p  class="scrollcoll">
                          <img src="${pageContext.request.contextPath}/images/codings/special-pattern-problem.png">
                           <span style="float: right;">
                           (${applicationScope.companyName})
                           </span>
                         </p>
                        
                   <p  class="probscrollcoll"> Given a input , you have to print the pattern as shown above.</p>
                   
                   <p  class="subscrollcoll"> Sample Input :  NA</p>
                         <p  class="subscrollcoll"> Sample Output :  You have to print the pattern as describe in Problem Statement</p>
                         
                        
                    </div>
                </div>
                <!-- END / BLOG LIST -->

                <!-- SIDEBAR -->
           <%@include file="/sidebar.jsp" %>
                <!-- END / SIDEBAR -->
  <br/>     <br/>      
      
            </div>
             <%@include file="/coding-area.jsp" %>
        </div>
 
    </section>
    <!-- END / BLOG -->
  

    
    
    <!-- FOOTER -->
 <!-- FOOTER -->
    <footer id="footer" class="footer">
<%--    <%@include file="/ffooter.jsp" %> --%>

       <%@include file="/sfooter.jsp" %>
    </footer>
    <!-- END / FOOTER -->
    <!-- END / FOOTER -->


    


</div>
<!-- END / PAGE WRAP -->

<!-- Load jQuery -->
  <%@include file="/js.jsp" %>
  <%@include file="/editor-settings.jsp" %>
  <%@include file="/dcode/java/longest-pattern-code.jsp" %>
  <%@include file="/editor-js.jsp" %>
  <%@include file="/time-out-popup.jsp" %>

</body>
</html>