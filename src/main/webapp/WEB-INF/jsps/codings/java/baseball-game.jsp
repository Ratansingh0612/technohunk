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
    <title>${companyName} - ${item.title} </title>
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
                      You're now a baseball game point recorder.
<br/> <br/>
Given a list of strings, each string can be one of the 4 following types:  <br/> <br/>

1) Integer (one round's score): Directly represents the number of points you get in this round. <br/><br/>
2) "+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points. <br/><br/>
3) "D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points. <br/><br/>
4) "C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed. <br/> <br/>
Each round's operation is permanent and could have an impact on the round before and the round after.
 <br/> <br/>
You need to return the sum of the points you could get in all the rounds.
                         </p>
                             <p  class="probscrollcoll"><b>Input Format</b> :  
                   	<br/>
					String[]  as an input       
			</p>
  <p  class="probscrollcoll"><b>Output Format</b> :  	<br/>
 	 You need to return the sum of the points you could get in all the rounds.
              
                  	                   	</p>
                   	                   	
               <p  class="subscrollcoll"> Sample Input :  
                   	<br/><b>"5"&nbsp;&nbsp;&nbsp;"2"&nbsp;&nbsp;&nbsp;"C"&nbsp;&nbsp;&nbsp;"D"&nbsp;&nbsp;&nbsp;"+"</b>
                   	<br/><br/>
                   	Sample Output :  <b>30</b><br/><br/>
                   <b>Explanation:</b> <br/>
Round 1: You could get 5 points. The sum is: 5.<br/>
Round 2: You could get 2 points. The sum is: 7.<br/>
Operation 1: The round 2's data was invalid. The sum is: 5.  <br/>
Round 3: You could get 10 points (the round 2's data has been removed). The sum is: 15.<br/>
Round 4: You could get 5 + 10 = 15 points. The sum is: 30.
                   	</p>
                         
                          <p  class="subscrollcoll"> Sample Input :  
                   	<br/><b>"5"&nbsp;&nbsp;&nbsp;"-2"&nbsp;&nbsp;&nbsp;"4"&nbsp;&nbsp;&nbsp;"C"&nbsp;&nbsp;&nbsp;"D"&nbsp;&nbsp;&nbsp;"9"&nbsp;&nbsp;&nbsp;"+"&nbsp;&nbsp;&nbsp;"+"</b>
                   	<br/><br/>
                   	Sample Output :  <b>27</b><br/><br/>
                   <b>Explanation:</b> <br/>
Round 1: You could get 5 points. The sum is: 5.<br/>
Round 2: You could get -2 points. The sum is: 3.<br/>
Round 3: You could get 4 points. The sum is: 7.<br/>
Operation 1: The round 3's data is invalid. The sum is: 3.  <br/>
Round 4: You could get -4 points (the round 3's data has been removed). The sum is: -1.<br/>
Round 5: You could get 9 points. The sum is: 8.<br/>
Round 6: You could get -4 + 9 = 5 points. The sum is 13.<br/>
Round 7: You could get 9 + 5 = 14 points. The sum is 27.
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
  <%@include file="/dcode/java/baseball-game-code.jsp" %>
  <%@include file="/editor-js.jsp" %>
  <%@include file="/time-out-popup.jsp" %>

</body>
</html>