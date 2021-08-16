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
    <title>${companyName} - Split String into Fibonacci Sequence</title>
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
                         <img src="${pageContext.request.contextPath}/images/codings/puzzle.jpg">
                         <br/>
                       Given a string S of digits, such as S = "123456579", we can split it into a Fibonacci-like sequence [123, 456, 579].
                        <br/> <br/>
                        Formally, a Fibonacci-like sequence is a list F of non-negative integers such that:
   <br/> <br/>
a) 0 <= F[i] <= 2^31 - 1, (that is, each integer fits a 32-bit signed integer type);<br/>
b) F.length >= 3;<br/>
c) and F[i] + F[i+1] = F[i+2] for all 0 <= i < F.length - 2.<br/>
  <br/> <br/>
Also, note that when splitting the string into pieces, each piece must not have extra leading zeroes, except if the piece is the number 0 itself.
                <br/> <br/>
                Return any Fibonacci-like sequence split from S, or return "" string with zero length if it cannot be done.
              
                         </p>
                             <p  class="probscrollcoll"><b>Input Format</b> :  
                   	<br/>
					String as an input       
			</p>
  <p  class="probscrollcoll"><b>Output Format</b> :  	<br/>
 	 Return any Fibonacci-like sequence split from S, or return "" string with zero length if it cannot be done.
              
                  	                   	</p>
                   	                   	
                   
               <p  class="subscrollcoll"> Sample Input :  
                   	<br/><b>"123456579"</b>
                   	<br/><br/>
                   	Sample Output :  <b>"123,&nbsp;456,&nbsp;579"</b>
                   	</p>
                         
                         
                               <p  class="probscrollcoll"> Sample Input :  
                   	<br/><b>"11235813"</b>
                   	 	<br/><br/>
                   	 	Sample Output :  <b>"1,&nbsp;1,&nbsp;2,&nbsp;3,&nbsp;5,&nbsp;8,&nbsp;13"</b>
                   	 	
                   	</p>
                          <p  class="subscrollcoll"> Sample Input :  
                   	<br/><b>"112358130"</b>
                   	<br/><br/>
                   	Sample Output :  <b>""</b>
                   	<br/><br/>
                   	<b>Explanation:</b> The task is impossible.
                   	</p>
                   	
                  <p  class="subscrollcoll"> Sample Input :  
                   	<br/><b>"0123"</b>
                   	<br/><br/>
                   	Sample Output :  <b>""</b>
                   	<br/><br/>
                   	<b>Explanation:</b> Leading zeroes are not allowed, so "01", "2", "3" is not valid.
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
  <%@include file="/dcode/java/split-array-into-fibonacci-sequence-code.jsp" %>
  <%@include file="/editor-js.jsp" %>
  <%@include file="/time-out-popup.jsp" %>

</body>
</html>