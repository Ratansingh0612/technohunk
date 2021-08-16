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
    <title>${companyName} -${item.title}</title>
    <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
    <![endif]-->
   
    
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
                         <img src="${pageContext.request.contextPath}/images/codings/sorting-number.png">
                         <br/> <br/>
                   	We are given an array asteroids of integers representing asteroids in a row.
                    <br/> <br/>
                   For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.        
                            <br/> <br/>
                            Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
                             </p>
                             
                             <p  class="probscrollcoll"><b>Input Format</b> :  
                   	<br/>
					Array of integers  as an input separated with space in single line.      
			</p>
  <p  class="probscrollcoll"><b>Output Format</b> :  	<br/>
 	 Return String with multiple values separated with single comma in single line
              
                  	                   	</p>
                   
               <p  class="subscrollcoll"> Sample Input :  
                   	<br/><b>5&nbsp;&nbsp; 10&nbsp;&nbsp;-5</b>
                   	<br/><br/>
                   	Sample Output :  <b> "5,10"</b><br/><br/>
                   	<b>Explanation:</b> <br/>
The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.
                   	
                   	</p>
                   	
                   	 <p  class="probscrollcoll"> Sample Input :  
                   	<br/><b>8&nbsp;&nbsp; -8</b>
                   	<br/><br/>
                   	Sample Output :  <b>""</b><br/><br/>
                   	<b>Explanation:</b> <br/>
The 8 and -8 collide exploding each other.
                   	</p>
                   	
                   	 <p  class="subscrollcoll"> Sample Input :  
                   	<br/><b>10&nbsp;&nbsp; 2&nbsp;&nbsp;-5</b>
                   	<br/><br/>
                   	Sample Output :  <b>"10"</b><br/><br/>
                   	<b>Explanation:</b> <br/>
The 2 and -5 collide resulting in -5.  The 10 and -5 collide resulting in 10.
                   	</p>
                   	
                   	
                   	  	 <p  class="probscrollcoll"> Sample Input :  
                   	<br/><b>-2&nbsp;&nbsp; -1&nbsp;&nbsp;1&nbsp;&nbsp; 2</b>
                   	<br/><br/>
                   	Sample Output :  <b>"-2, -1, 1, 2"</b><br/><br/>
                   	<b>Explanation:</b> <br/>
The -2 and -1 are moving left, while the 1 and 2 are moving right.
Asteroids moving the same direction never meet, so no asteroids will meet each other.
                   	</p>
                   	
                   	 <p  class="subscrollcoll">
                   	<b>Note:</b>
	<br/><br/>
The length of asteroids will be at most 10000.<br/>
Each asteroid will be a non-zero integer in the range [-1000, 1000]..<br/>
</p>
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
  <%@include file="/dcode/java/asteroid-collision-code.jsp" %>
  <%@include file="/editor-js.jsp" %>
  <%@include file="/time-out-popup.jsp" %>

</body>
</html>