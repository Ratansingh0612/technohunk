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
    <title>${companyName} -Save Prisoner Problem </title>
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
                     <img src="${pageContext.request.contextPath}/images/codings/prisoner-icon.jpg">
                   A jail has a number of prisoners and a number of treats to pass out to them.
                    Their jailer decides the fairest way to divide the treats is to seat the prisoners 
                    around a circular table in sequentially numbered chairs.
                     A chair number will be drawn from a hat. Beginning with the prisoner in that chair, 
                     one candy will be handed to each prisoner sequentially around the table until all have been 
                     distributed. 
                     
<br/><br/>
The jailer is playing a little joke, though. The last piece of candy looks like all the others, but it tastes awful . 
Determine the chair number occupied by the prisoner who will receive that candy.
<br/><br/> 
<b>For example,</b> there are <b>4</b> prisoners and <b>6</b> pieces of candy.
 The prisoners arrange themselves in seats numbered <b>1</b> to <b>4</b>. 
 Let's suppose two is drawn from the hat. Prisoners receive candy at positions <b>2,3,4,1,2,3</b> . 
 The prisoner to be warned sits in chair number <b>3</b> . 

                   
                   </p>
                   
                    <p  class="probscrollcoll"> <b>Function Description </b>  <br/>  
                   		Complete the saveThePrisoner function in the editor below.
                   		 It should return an integer representing the chair number of the prisoner to warn. 
                   		 <br/> <br/>
                   		 saveThePrisoner has the following parameter(s):
                   		  <br/><br/>
                   		  <b>n :</b> an integer, the number of prisoners
                   		    <br/>
                   		   <b>m :</b> an integer, the number of sweets 
                   		     <br/>
                   		   <b>s :</b> an integer, the chair number to begin passing out sweets from 
                   		<br/>	
                   
                   <p  class="probscrollcoll"> Sample Input :
                   		<br/>  
                   		5
                   		<br/>
                   		2
                   		<br/>
                   		1
                   		
                   		</p>
                         <p  class="subscrollcoll"> Sample Output :  2</p>
                         
                         
                           <p  class="probscrollcoll"> Sample Input :
                   		<br/>  
                   		5
                   		<br/>
                   		2
                   		<br/>
                   		2
                   		
                   		</p>
                         <p  class="subscrollcoll"> Sample Output :  3</p>
                         
                        
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
  <%@include file="/dcode/java/save-prisoner-code.jsp" %>
  <%@include file="/editor-js.jsp" %>
  <%@include file="/time-out-popup.jsp" %>

</body>
</html>