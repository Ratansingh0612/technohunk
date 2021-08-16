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
    <title>${companyName} -House Robber Problem!</title>
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
                         <img src="${pageContext.request.contextPath}/images/codings/gas-station.png">
                         <br/>
                         There are <b>N</b> gas stations along a circular route, where the amount of gas at station i is <b>gas[i]</b>.
  <br/> <br/>
  You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
   <br/> <br/>
   Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
        <br/> <br/>
        <b>Note:</b> <br/>
        a) If there exists a solution, it is guaranteed to be unique. <br/>
b) Both input arrays are non-empty and have the same length. <br/>
c) Each element in the input arrays is a non-negative integer. <br/>
                         </p>
                             <p  class="probscrollcoll"><b>Input Format</b> :  
                   	<br/>
                   	first line represents N gas stations  where the amount of gas at station i is gas[i]
                   	& second line represents it costs <b>cost[i]</b> of gas to travel from station i to its next station <b>(i+1)</b>
						</p>
  <p  class="probscrollcoll"><b>Output Format</b> :  	<br/>
Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
  
                   	                   	</p>
                   	                   	
                   
                   <p  class="subscrollcoll">Sample Input :  
                   	<br/>
                   	<b>1&nbsp;&nbsp;2&nbsp;&nbsp;3&nbsp;&nbsp;4&nbsp;&nbsp;5&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->>> gas</b><br/>
                   		<b>3&nbsp;&nbsp;4&nbsp;&nbsp;5&nbsp;&nbsp;1&nbsp;&nbsp;2&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->>> cost </b>
                   	<br/><br/>
                   	Sample Output :  <b>3</b><br/><br/>
                   	<b>Explanation:</b><br/>
Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4<br/>
Travel to station 4. Your tank = 4 - 1 + 5 = 8<br/>
Travel to station 0. Your tank = 8 - 2 + 1 = 7<br/>
Travel to station 1. Your tank = 7 - 3 + 2 = 6<br/>
Travel to station 2. Your tank = 6 - 4 + 3 = 5<br/>
Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.<br/>
Therefore, return 3 as the starting index.
                   	</p>
                   	
                   	
                  <p  class="subscrollcoll">Sample Input :  
                   	<br/>
                   	<b>2&nbsp;&nbsp;3&nbsp;&nbsp;4&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->>> gas</b><br/>
                   		<b>3&nbsp;&nbsp;4&nbsp;&nbsp;3&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ->>> cost </b>
                   	<br/><br/>
                   	Sample Output :  <b>-1</b><br/><br/>
                   	<b>Explanation:</b><br/>
            You can't start at station 0 or 1, as there is not enough gas to travel to the next station.<br/>
Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4<br/>
Travel to station 0. Your tank = 4 - 3 + 2 = 3<br/>
Travel to station 1. Your tank = 3 - 3 + 3 = 3<br/>
You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.<br/>
Therefore, you can't travel around the circuit once no matter where you start.<br/>
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
  <%@include file="/dcode/java/gas-station-code.jsp" %>
  <%@include file="/editor-js.jsp" %>
  <%@include file="/time-out-popup.jsp" %>

</body>
</html>