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
    <title>${companyName} -Angry Professor Problem </title>
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
                        <%--  <p  class="scrollcoll">
                          <img src="${pageContext.request.contextPath}/images/codings/fact-num.png">
                        </p> --%>
                   <p  class="probscrollcoll">
                     <img src="${pageContext.request.contextPath}/images/codings/angry-professor.gif">
                   A Discrete Mathematics professor has a class of <b>N</b> students. Frustrated with their lack of discipline, he decides to cancel class if fewer than <b>K</b>  students are present when class starts.
                   </p>
                   
                    <p  class="probscrollcoll"> <b>Input Format </b>  <br/>  
                   		The first line integers represent <b>N</b> students in the class, The second line integers represent <b>K</b> (the cancelation threshold) and the third 
                   		line contains  <b>N</b>  space-separated integers (<b>a1,a2,a3.....aN</b> ) describing the arrival times for each student.

Note: Non-positive arrival times (   ) indicate the student arrived early or on time; positive arrival times (   ) indicate the student arrived   minutes late.

                   		<br/>		<br/>
                   		<b>Note:</b> Non-positive arrival times (<b>a(i)<=0</b>) indicate the student arrived early or on time; positive arrival times (<b>a(i)>0</b>) indicate the student arrived a(i) minutes late.
                   </p>
                   
                   For each test case, print the word YES if the class is canceled or NO if it is not.
                   	
                   	 <p  class="probscrollcoll"> <b>Output Format </b>  <br/>  
                   	 For each test case, print the word <b>YES</b> if the class is canceled or <b>NO</b> if it is not.
                   	 </p>
                   
                   <p  class="probscrollcoll"> Sample Input :
                   		<br/>  
                   		4
                   		<br/>
                   		3
                   		<br/>
                   		-1 -3 4 2
                   		
                   		</p>
                         <p  class="subscrollcoll"> Sample Output :  YES</p>
                         
                         
                           <p  class="probscrollcoll"> Sample Input :
                   		<br/>  
                   		4
                   		<br/>
                   		2
                   		<br/>
                   		0 -1 2 1
                   		
                   		</p>
                         <p  class="subscrollcoll"> Sample Output :  NO</p>
                        <p  class="probscrollcoll"> <b>Explanation :</b>
                   		<br/>  
                   		For the first test case,  <b>K=3</b>  . The professor wants at least <b>3</b> students in attendance, but only <b>2</b>  have arrived on time ( <b>-3</b> and <b>-1</b> ). Thus, the class is canceled.
<br/><br/>
For the second test case,  <b>K=2</b>    . The professor wants at least <b>2</b> students in attendance, and there are <b>2</b>  who have arrived on time ( <b>-0</b> and <b>-1</b>  ). Thus, the class is not canceled.
                   		
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
  <%@include file="/dcode/java/angry-professor-code.jsp" %>
  <%@include file="/editor-js.jsp" %>
  <%@include file="/time-out-popup.jsp" %>

</body>
</html>