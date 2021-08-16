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
    <title>${companyName} -Buddy String</title>
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
                         <img src="${pageContext.request.contextPath}/images/codings/kangaroo-problem.png">
                         <br/>
            You are choreographing a circus show with various animals. For one act, you are given two kangaroos on a number line ready to jump in the positive direction (i.e., toward positive infinity).  <br/>
  <br/>
1.The first kangaroo starts at location x1 and moves at a rate of v1 meters per jump.  <br/>
  <br/>

2.The second kangaroo starts at location x2 and moves at a rate of v2 meters per jump.  <br/>
  <br/>

You have to figure out a way to get both kangaroos at the same location as part of the show.  <br/>
Complete the function kangaroo which takes starting location and speed of both kangaroos as input, and return Yes or No appropriately. Can you determine if the kangaroos will ever land at the same location at the same time? The two kangaroos must land at the same location after making the same number of jumps.


 
                         </p>
                             <p  class="probscrollcoll"><b>Input Format</b> :  
                   	<br/>
                   		A single line of four space-separated integers denoting the respective values of x1, v1, x2, and v2. 
                   			<br/>	<br/>
                   		<b>Constraints</b>	<br/>
*	0 <= x1 < x2 <= 10000	<br/>
*	1 <= v1 <= 10000	<br/>
*	1 <= v2 <= 10000	<br/>

  <p  class="probscrollcoll"><b>Output Format</b> :  	<br/>
  Print YES if they can land on the same location at the same time; otherwise, print NO.
<b>Note:</b> The two kangaroos must land at the same location after making the same number of jumps.
  
                   	                   	</p>
                   	                   	
                   
                   <p  class="subscrollcoll">Ex-1 Sample Input :  
                   	<br/>
                   	<b>0 &nbsp;&nbsp;3&nbsp;&nbsp; 4&nbsp;&nbsp; 2</b><br/>
                   	<br/><br/>
                   	Sample Output :  YES<br/><br/>
                   	<b>Explanation</b><br/>
                   	The two kangaroos jump through the following sequence of locations:<br/>
					From the image, it is clear that the kangaroos meet at the same location (number 12 on the number line) after same number of jumps (4 jumps), and we print YES .
					 <img src="${pageContext.request.contextPath}/images/codings/kangaroo-explain.png">
                   	
                   	</p>
                         
                     <p  class="subscrollcoll">Ex-2 Sample Input :  
                   	<br/>
                   	<b>0 &nbsp;&nbsp;2&nbsp;&nbsp; 5&nbsp;&nbsp; 3</b><br/>
                   	<br/><br/>
                   	Sample Output :  NO<br/><br/>
                   	<b>Explanation</b><br/>
                 The second kangaroo has a starting location that is ahead (further to the right) of the first kangaroo's
				 Starting location (i.e., x2>x1). Because the second kangaroo moves at a faster rate (meaning v2 v1) and is already ahead of the first kangaroo, the first kangaroo will never be able to catch up. Thus, we print NO.
	
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
  <%@include file="/dcode/java/kangaroo-problem-code.jsp" %>
  <%@include file="/editor-js.jsp" %>
  <%@include file="/time-out-popup.jsp" %>

</body>
</html>